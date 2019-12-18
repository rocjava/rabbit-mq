package com.penn.rabbitmq.consumer.demo3.config;

import org.springframework.context.annotation.Configuration;


/**
 * @author penn
 * @since 2019/12/17
 */
@Configuration
public class RabbitConfig {

    /**
     * 一对多
     */
    public static final String DEMO_QUEUE_1 = "demoQueue1";

    /**
     * 多对一
     */
    public static final String DEMO_QUEUE_2 = "demoQueue2";

    /**
     * 一对一对一
     */
    public static final String DEMO_QUEUE_3 = "demoQueue3";

    public static final String DEMO_EXCHANGE_4 = "demoExchange4";

    public static final String DEMO_ROUTING_KEY_40 = "demoRoutingKey40";


    /**
     * topic
     */
    public static final String DEMO_QUEUE_4 = "demoQueue4";

    public static final String DEMO_TOPIC_EXCHANGE_1 = "demoTopicExchange1";

    public static final String DEMO_TOPIC_EXCHANGE_ROUTING_KEY_10 = "demoTopicRoutingKey.#";

    /**
     * fanout
     */
    public static final String DEMO_QUEUE_5 = "demoQueue5";

    public static final String DEMO_QUEUE_6 = "demoQueue6";
}
