package com.sunc;

import com.sunc.vo.Token;
import com.sunc.vo.User;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

@SpringBootApplication
public class DesignWebAdminApplication {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //SpringApplication.run(DesignWebAdminApplication.class, args);// 手动运行Spring Boot应用)
        ConfigurableApplicationContext context = SpringApplication.run(DesignWebAdminApplication.class, args);
        Field singletonObjects = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");
        singletonObjects.setAccessible(true);
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        Map<String, Objects> map = (Map<String, Objects>)singletonObjects.get(beanFactory);
        //map.entrySet().forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
        map.entrySet().stream()
                .filter(e -> e.getKey()
                        .startsWith("user")).forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));

        DefaultListableBeanFactory listableBeanFactory = new DefaultListableBeanFactory();

        AbstractBeanDefinition beanDefinition =
                BeanDefinitionBuilder.genericBeanDefinition(User.class).setScope("singleton").getBeanDefinition();
        listableBeanFactory.registerBeanDefinition("user",beanDefinition);
        listableBeanFactory.registerBeanDefinition("token"
                ,BeanDefinitionBuilder.genericBeanDefinition(Token.class).getBeanDefinition());
        AnnotationConfigUtils.registerAnnotationConfigProcessors(listableBeanFactory);

        listableBeanFactory.getBeansOfType(BeanFactoryPostProcessor.class).values()
                .forEach(b -> b.postProcessBeanFactory(listableBeanFactory));

        listableBeanFactory.getBeansOfType(BeanPostProcessor.class)
                .values().forEach(listableBeanFactory::addBeanPostProcessor);

        for(String name : listableBeanFactory.getBeanDefinitionNames()){
            System.out.println(name);
        }


        System.out.println(listableBeanFactory.getBean(User.class).getToken());
        //beanPostProcessors.forEach(beanPostProcessor -> listableBeanFactory.addBeanPostProcessor(beanPostProcessor));
    }



}
