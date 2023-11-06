package gsc.projects.emailservice.consumer;


import gsc.projects.emailservice.dto.Order;
import gsc.projects.emailservice.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);


    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consumer(OrderEvent orderEvent){
        LOGGER.info(String.format("Order received on email service -> %s", orderEvent.toString()));
    }
}
