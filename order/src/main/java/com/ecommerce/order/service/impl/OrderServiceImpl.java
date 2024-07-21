package com.ecommerce.order.service.impl;

import com.ecommerce.order.exception.BusinessException;
import com.ecommerce.order.kafka.OrderProducer;
import com.ecommerce.order.model.OrderConfirmation;
import com.ecommerce.order.model.OrderRequest;
import com.ecommerce.order.model.OrderResponse;
import com.ecommerce.order.model.orderline.OrderLineRequest;
import com.ecommerce.order.model.product.PurchaseRequest;
import com.ecommerce.order.payment.PaymentClient;
import com.ecommerce.order.payment.PaymentRequest;
import com.ecommerce.order.repository.OrderRepository;
import com.ecommerce.order.service.CustomerClient;
import com.ecommerce.order.service.OrderMapper;
import com.ecommerce.order.service.OrderService;
import com.ecommerce.order.service.ProductClient;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderLineService orderLineService;
    private OrderMapper orderMapper;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    public OrderServiceImpl(OrderRepository orderRepository, CustomerClient customerClient, ProductClient productClient, OrderLineService orderLineService, OrderProducer orderProducer, PaymentClient paymentClient) {
        this.orderRepository = orderRepository;
        this.customerClient = customerClient;
        this.productClient = productClient;
        this.orderLineService = orderLineService;
        this.orderProducer = orderProducer;
        this.paymentClient = paymentClient;
    }

    @Override
    public Integer createOrder(OrderRequest orderRequest) {
        var customer = this.customerClient.findCustomerById(orderRequest.getCustomerId())
                .orElseThrow(() -> new BusinessException("can not create order:: No Customer exists with Customer ID:" + orderRequest.getCustomerId()));

        var purchasedProducts = this.productClient.purchaseProducts(orderRequest.getProducts());
        var order = this.orderRepository.save(orderMapper.toOrder(orderRequest));

        for (PurchaseRequest purchaseRequest : orderRequest.getProducts()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.getProductId(),
                            purchaseRequest.getQuantity()
                    )
            );
        }

        var paymentRequest = new PaymentRequest(
                orderRequest.getAmount(),
                orderRequest.getPaymentMethod(),
                orderRequest.getId(),
                orderRequest.getReference(),
                customer
        );

        paymentClient.requestOrderPayment(paymentRequest);

        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        orderRequest.getReference(),
                        orderRequest.getAmount(),
                        orderRequest.getPaymentMethod(),
                        customer,
                        purchasedProducts
                )
        );

        return order.getId();
    }

    @Override
    public List<OrderResponse> findAll() {
        return orderRepository.findAll().stream().map(orderMapper::fromOrder).collect(Collectors.toList());
    }

    @Override
    public OrderResponse findById(Integer orderId) {
        return orderRepository.findById(orderId)
                .map(orderMapper::fromOrder)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No order found with the provided ID %d::", orderId)));
    }
}
