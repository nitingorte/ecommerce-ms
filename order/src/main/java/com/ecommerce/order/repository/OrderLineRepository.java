package com.ecommerce.order.repository;

import com.ecommerce.order.model.OrderLine;
import com.ecommerce.order.model.OrderLineResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine,Integer> {
    List<OrderLine> findAllByOrderId(Integer orderId);
}
