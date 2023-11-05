package gsc.projects.orderservice.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.stock.name}")
    private String stockQueueName;

    @Value("${rabbitmq.queue.email.name}")
    private String emailQueueName;

    @Value("${rabbitmq.stock.routing.key}")
    private String stockRoutingKey;

    @Value("${rabbitmq.email.routing.key}")
    private String emailRoutingKey;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;


   @Bean
   public Queue stockQueue(){
       return new Queue(stockQueueName);
   }

   @Bean
    public Queue emailQueue(){
       return new Queue(emailQueueName);
   }

   @Bean
    public TopicExchange exchange(){
       return new TopicExchange(exchangeName);
   }


   @Bean
    public Binding bindingStock(){
       return BindingBuilder
               .bind(stockQueue())
               .to(exchange())
               .with(stockRoutingKey);
   }

   @Bean
    public Binding bindingEmail(){
       return BindingBuilder
               .bind(emailQueue())
               .to(exchange())
               .with(emailRoutingKey);
   }

   @Bean
    public MessageConverter converter(){
       return new Jackson2JsonMessageConverter();
   }

   @Bean
    public RabbitTemplate rabbitTemplateConfig(ConnectionFactory connectionFactory){
       RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
       rabbitTemplate.setMessageConverter(converter());
       return rabbitTemplate;
   }

}
