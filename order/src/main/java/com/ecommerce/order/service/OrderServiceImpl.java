package com.ecommerce.order.service;

import com.ecommerce.order.exception.BusinessException;
import com.ecommerce.order.model.OrderRequest;
import com.ecommerce.order.model.orderline.OrderLineRequest;
import com.ecommerce.order.model.product.PurchaseRequest;
import com.ecommerce.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderLineService orderLineService;
    private OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, CustomerClient customerClient, ProductClient productClient, OrderLineService orderLineService) {
        this.orderRepository = orderRepository;
        this.customerClient = customerClient;
        this.productClient = productClient;
        this.orderLineService = orderLineService;
    }

    @Override
    public Integer createOrder(OrderRequest orderRequest) {
        var customer = this.customerClient.findCustomerById(orderRequest.getCustomerId())
                .orElseThrow(() -> new BusinessException("can not create order:: No Customer exists with Customer ID:" + orderRequest.getCustomerId()));

        this.productClient.purchaseProducts(orderRequest.getProducts());
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

        return null;
    }
}
