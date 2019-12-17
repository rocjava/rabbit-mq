package com.penn.rabbitmq.provider.demo.controller;

import com.penn.rabbitmq.provider.demo.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author penn
 * @since 2019/12/17
 */
@RestController
public class RabbitController {

    private static final String SUCCESS = "SUCCESS";

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/demo")
    public String sendDemoMQ() {
        rabbitTemplate.convertAndSend(RabbitConfig.DEMO_EXCHANGE, RabbitConfig.DEMO_ROUTING_KEY, "hello rabbit");
        return SUCCESS;
    }
}
