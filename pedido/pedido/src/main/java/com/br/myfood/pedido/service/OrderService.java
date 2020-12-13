package com.br.myfood.pedido.service;

import com.br.myfood.pedido.entity.Order;
import com.br.myfood.pedido.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order insertOrder(Order order) {
        return orderRepository.save(order);
    }
}
