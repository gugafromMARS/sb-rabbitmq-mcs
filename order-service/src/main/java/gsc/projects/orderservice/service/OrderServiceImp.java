package gsc.projects.orderservice.service;


import gsc.projects.orderservice.model.Order;
import gsc.projects.orderservice.model.OrderEvent;
import gsc.projects.orderservice.producer.RabbitMQProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderServiceImp implements OrderService {

    private final RabbitMQProducer rabbitMQProducer;

    @Override
    public void sendOrder(Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setMessage(String.format("Order with %s", order.getName()));
        orderEvent.setStatus("Pending");
        orderEvent.setOrder(order);
        rabbitMQProducer.sendOrderToEmail(orderEvent);
        rabbitMQProducer.sendOrderToStock(orderEvent);
    }
}
