package gsc.projects.orderservice.producer;


import gsc.projects.orderservice.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);

    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.stock.routing.key}")
    private String stockRoutingKey;

    @Value("${rabbitmq.email.routing.key}")
    private String emailRoutingKey;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    //send for stock queue
    public void sendOrderToStock(Order order){
        LOGGER.info(String.format("Order sent to stock -> %s", order.toString()));

        rabbitTemplate.convertAndSend(exchange, stockRoutingKey, order);
    }

    //send for email queue
    public void sendOrderToEmail(Order order){
        LOGGER.info(String.format("Order sent to email -> %s", order.toString()));

        rabbitTemplate.convertAndSend(exchange, emailRoutingKey, order);
    }

}
