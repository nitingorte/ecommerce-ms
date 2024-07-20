package com.ecommerce.order.controller;

import com.ecommerce.order.model.OrderLineResponse;
import com.ecommerce.order.model.orderline.OrderLineMapper;
import com.ecommerce.order.service.impl.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/order-lines")
@RequiredArgsConstructor
public class OrderLineController {

    private final OrderLineService orderLineService;
    private final OrderLineMapper orderLineMapper;

    @GetMapping("/order/{order-id}")
    public ResponseEntity<List<OrderLineResponse>> findByOrderId(@PathVariable("order-id") Integer orderId){
        return ResponseEntity.ok(orderLineService.findAllByOrderId(orderId));
    }
}
