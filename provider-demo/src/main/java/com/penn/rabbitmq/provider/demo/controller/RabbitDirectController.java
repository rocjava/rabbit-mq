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

    /**
     * 一对多对一
     */

    @GetMapping("/demoDirect10")
    public String sendDemoMQ10() {
        rabbitTemplate.convertAndSend(RabbitConfig.DEMO_EXCHANGE_1, RabbitConfig.DEMO_ROUTING_KEY_10, "hello rabbit");
        return SUCCESS;
    }

    @GetMapping("/demoDirect11")
    public String sendDemoMQ11() {
        rabbitTemplate.convertAndSend(RabbitConfig.DEMO_EXCHANGE_1, RabbitConfig.DEMO_ROUTING_KEY_11, "hello rabbit");
        return SUCCESS;
    }

    @GetMapping("/demoDirect12")
    public String sendDemoMQ12() {
        rabbitTemplate.convertAndSend(RabbitConfig.DEMO_EXCHANGE_1, RabbitConfig.DEMO_ROUTING_KEY_12, "hello rabbit");
        return SUCCESS;
    }


    /**
     * 一对多
     */
    @GetMapping("/demoDirect20")
    public String sendDemoMQExchange() {
        rabbitTemplate.convertAndSend(RabbitConfig.DEMO_EXCHANGE_2, RabbitConfig.DEMO_ROUTING_KEY_20, "hello rabbit");
        return SUCCESS;
    }

    /**
     * 多对多
     */
    @GetMapping("/demoDirect30")
    public String sendDemoMQ30() {
        rabbitTemplate.convertAndSend(RabbitConfig.DEMO_EXCHANGE_2, RabbitConfig.DEMO_ROUTING_KEY_20, "hello rabbit");
        return SUCCESS;
    }


    /**
     * DIRECT 一对一对一
     * @return
     */
    @GetMapping("/demoDirect40")
    public String sendDemoMQ40() {
        rabbitTemplate.convertAndSend(RabbitConfig.DEMO_EXCHANGE_4, RabbitConfig.DEMO_ROUTING_KEY_40, "hello rabbit");
        return SUCCESS;
    }

    @GetMapping("/demoDirect41")
    public String sendDemoMQ41() {
        rabbitTemplate.convertAndSend(RabbitConfig.DEMO_EXCHANGE_4, "aabbcc", "hello rabbit");
        return SUCCESS;
    }

    /**
     * TOPIC 模式
     */

    @GetMapping("/demoTopic10")
    public String sendDemoMQTopic10() {
        rabbitTemplate.convertAndSend(RabbitConfig.DEMO_TOPIC_EXCHANGE_1, "demoTopicRoutingKey.first", "hello rabbit");
        return SUCCESS;
    }

    @GetMapping("/demoTopic11")
    public String sendDemoMQTopic11() {
        rabbitTemplate.convertAndSend(RabbitConfig.DEMO_TOPIC_EXCHANGE_1, "demoTopicRoutingKey.second", "hello rabbit");
        return SUCCESS;
    }

    @GetMapping("/demoTopic12")
    public String sendDemoMQTopic12() {
        rabbitTemplate.convertAndSend(RabbitConfig.DEMO_TOPIC_EXCHANGE_1, "demoTopicRoutingKey.third", "hello rabbit");
        return SUCCESS;
    }

    @GetMapping("/demoTopic13")
    public String sendDemoMQTopic13() {
        rabbitTemplate.convertAndSend(RabbitConfig.DEMO_TOPIC_EXCHANGE_1, "demoTopicRoutingKeyFourth", "hello rabbit");
        return SUCCESS;
    }

    /**
     * FANOUT 模式
     */

    @GetMapping("/demoFanout10")
    public String sendDemoMQFanout10() {
        rabbitTemplate.convertAndSend(RabbitConfig.DEMO_FANOUT_EXCHANGE_1, "",  "hello rabbit");
        return SUCCESS;
    }

}
