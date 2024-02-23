package com.sunc;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DesignWebApiApplication {
    public static void main(String[] args){
        SpringApplication.run(DesignWebApiApplication.class, args);// 手动运行Spring Boot应用)
    }

}
