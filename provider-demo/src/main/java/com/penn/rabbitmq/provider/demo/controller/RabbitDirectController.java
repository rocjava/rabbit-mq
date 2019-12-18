package com.penn.rabbitmq.provider.demo.controller;

import com.penn.rabbitmq.provider.demo.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author penn
 * @since 2019/12/17
 */
@RestController
@RequestMapping("/direct")
public class RabbitDirectController {

    private static final String SUCCESS = "SUCCESS";

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/demoDirect")
    public String sendDemoMQ() {
        rabbitTemplate.convertAndSend(RabbitConfig.DEMO_EXCHANGE, RabbitConfig.DEMO_ROUTING_KEY, "hello rabbit");
        return SUCCESS;
    }

    @GetMapping("/demoDirect1")
    public String sendDemoMQ1() {
        rabbitTemplate.convertAndSend(RabbitConfig.DEMO_EXCHANGE, RabbitConfig.DEMO_ROUTING_KEY_1, "hello rabbit");
        return SUCCESS;
    }

    @GetMapping("/demoDirect2")
    public String sendDemoMQ2() {
        rabbitTemplate.convertAndSend(RabbitConfig.DEMO_EXCHANGE, RabbitConfig.DEMO_ROUTING_KEY_2, "hello rabbit");
        return SUCCESS;
    }

    @GetMapping("/demoDirectExchange")
    public String sendDemoMQExchange() {
        rabbitTemplate.convertAndSend(RabbitConfig.DEMO_EXCHANGE_1, RabbitConfig.DEMO_ROUTING_KEY, "hello rabbit");
        return SUCCESS;
    }

    @GetMapping("/demoDirectExchangeWithoutRoutingKey")
    public String sendDemoMQExchangeWithoutRoutingKey() {
        rabbitTemplate.convertAndSend(RabbitConfig.DEMO_EXCHANGE_3, "", "hello rabbit");
        return SUCCESS;
    }



    @GetMapping("/demoDirectNExchange2OneQueue")
    public String sendDemoMNExchange2OneQueue() {
        rabbitTemplate.convertAndSend(RabbitConfig.DEMO_EXCHANGE_1, RabbitConfig.DEMO_ROUTING_KEY, "hello rabbit");
        return SUCCESS;
    }
}
