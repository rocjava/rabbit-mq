package com.penn.rabbitmq.consumer.demo3;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author penn.zhang
 */
@EnableRabbit
@SpringBootApplication
public class ConsumerDemo3Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDemo3Application.class, args);
    }

}
