package gsc.projects.orderservice.service;

import gsc.projects.orderservice.model.Order;

public interface OrderService {
    void sendOrder(Order order);
}
