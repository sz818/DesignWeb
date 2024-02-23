package com.sunc.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.amqp.rabbit.retry.RepublishMessageRecoverer;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "spring.rabbitmq.listener.simple.retry" ,name = "enabled" ,havingValue = "true")
public class ErrorMqConfiguration {
    @Bean
    public DirectExchange errorExchange(){
        return ExchangeBuilder.directExchange("error.direct").durable(true).build();
    }
    @Bean
    public Queue errorQueue(){
        return new Queue("error.queue",true);
    }
    @Bean
    public Binding errorBinding(Exchange errorExchange,Queue errorQueue){
        return BindingBuilder.bind(errorQueue).to(errorExchange).with("error").noargs();
    }

    @Bean
    public MessageRecoverer messageRecoverer(RabbitTemplate rabbitTemplate){
        return new RepublishMessageRecoverer(rabbitTemplate,"error.direct","error");

    }
}
