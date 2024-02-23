package com.sunc.config;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class MqConfig {
    /*@Resource
    private ConnectionFactory connectionFactory;*/

    @Bean
    public RabbitTemplate creatRabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setReturnsCallback(message -> {
            log.info("应答码{ " + message.getReplyCode() +
                    " },原因{ " + message.getReplyText() +
                    " },交换机{ " + message.getExchange() +
                    ", }路由键{ " + message.getRoutingKey() +
                    " },消息{ " + message.getMessage() + " }");
        });

        //确认消息送到交换机回调
        /*rabbitTemplate.setConfirmCallback(
                new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                log.info("[确认消息送到交换机结果][相关数据:{}][是否成功:{}][错误原因:{}]",correlationData,ack,cause);
            }
        });*/
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) ->{
            if(ack){
                log.info("[ack,消息发送到Exchange成功][msgId:{}]");
            }else {
                log.error("[nack,消息发送到Exchange失败][相关数据:{}][是否成功:{}][错误原因:{}]"
                        ,correlationData
                        ,ack
                        ,cause);
                //saveToDb(
            }
        });
        return rabbitTemplate;
    }
}
