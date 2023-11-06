package gsc.projects.stockservice.consumer;


import gsc.projects.stockservice.dto.Order;
import gsc.projects.stockservice.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(OrderEvent orderEvent){
        LOGGER.info(String.format("Order received in stock service -> %s", orderEvent.toString()));
    }
}
