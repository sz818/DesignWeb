/*
package com.sunc.consumer;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RabbitMqConfiguration {
    @Bean
    public TopicExchange topicExchange(){
        return ExchangeBuilder.topicExchange("design.api.exchange").build();
        //return new TopicExchange("design.api.exchange");
    }
    @Bean
    public Queue queue1(){
        return QueueBuilder.durable("design.api.queue1").build();
        //return new Queue("design.api.queue1");
    }

    @Bean
    public Queue queue2(){
        //durable持久化(队列存入磁盘)
        return QueueBuilder.durable("design.api.queue2").build();
       // return new Queue("design.api.queue2");  // 默认持久化
    }

    @Bean
    public Binding binding1(Exchange topicExchange, Queue queue1){
        return BindingBuilder.bind(queue1()).to(topicExchange()).with("#.news");
    }

    @Bean
    public Binding binding2(Exchange topicExchange, Queue queue1){
        return BindingBuilder.bind(queue2()).to(topicExchange()).with("#.weather");
    }
}
*/
