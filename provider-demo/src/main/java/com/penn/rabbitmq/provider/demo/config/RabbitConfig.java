package com.penn.rabbitmq.provider.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author penn
 * @since 2019/12/17
 */
@Configuration
public class RabbitConfig {



    /**
     * case 1
     * 一个queue和一个exchange绑定多个routingKey
     */
    public static final String DEMO_QUEUE_1 = "demoQueue1";

    public static final String DEMO_EXCHANGE_1 = "demoExchange1";

    public static final String DEMO_ROUTING_KEY_10 = "demoRoutingKey10";

    public static final String DEMO_ROUTING_KEY_11 = "demoRoutingKey11";

    public static final String DEMO_ROUTING_KEY_12 = "";

    @Bean("demoQueue1")
    public Queue testDemoQueue(){
        return QueueBuilder.durable(DEMO_QUEUE_1).build();
    }

    @Bean("demoExchange1")
    public DirectExchange testDirectExchange(){
        return ExchangeBuilder.directExchange(DEMO_EXCHANGE_1).durable(true).build();
    }

    @Bean
    public Binding demoBinding10(@Qualifier("demoQueue1") Queue queue,
                                       @Qualifier("demoExchange1") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(DEMO_ROUTING_KEY_10);
    }

    @Bean
    public Binding demoBinding11(@Qualifier("demoQueue1") Queue queue,
                               @Qualifier("demoExchange1") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(DEMO_ROUTING_KEY_11);
    }

    @Bean
    public Binding demoBinding12(@Qualifier("demoQueue1") Queue queue,
                                @Qualifier("demoExchange1") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(DEMO_ROUTING_KEY_12);
    }

    /**
     * case 2
     * 一个queue和多个exchange绑定
     */
    public static final String DEMO_EXCHANGE_2 = "demoExchange2";

    public static final String DEMO_ROUTING_KEY_20 = "demoRoutingKey20";

    @Bean("demoExchange2")
    public DirectExchange testDirectExchange2(){
        return ExchangeBuilder.directExchange(DEMO_EXCHANGE_2).durable(true).build();
    }

    @Bean
    public Binding demoBinding20(@Qualifier("demoQueue1") Queue queue,
                               @Qualifier("demoExchange2") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(DEMO_ROUTING_KEY_20);
    }


    /**
     * case 3
     * 一个exchange绑定多个queue
     */
    public static final String DEMO_QUEUE_2 = "demoQueue2";

    @Bean("demoQueue2")
    public Queue testDemoQueue2(){
        return QueueBuilder.durable(DEMO_QUEUE_2).build();
    }

    @Bean
    public Binding demoBinding30(@Qualifier("demoQueue2") Queue queue,
                                       @Qualifier("demoExchange2") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(DEMO_ROUTING_KEY_20);
    }

    /**
     * case 4
     * 简单模式，一个queue对应一个exchange，指定一个routingKey
     * 一个queue只消费一个routingKey
     */
    public static final String DEMO_QUEUE_3 = "demoQueue3";

    public static final String DEMO_EXCHANGE_4 = "demoExchange4";

    public static final String DEMO_ROUTING_KEY_40 = "demoRoutingKey40";

    @Bean("demoQueue3")
    public Queue testDemoQueue3(){
        return QueueBuilder.durable(DEMO_QUEUE_3).build();
    }

    @Bean("demoExchange4")
    public DirectExchange testDirectExchange4(){
        return ExchangeBuilder.directExchange(DEMO_EXCHANGE_4).durable(true).build();
    }

    @Bean
    public Binding demoBindingRoutingKeyQueueConsumer(@Qualifier("demoQueue3") Queue queue,
                                                 @Qualifier("demoExchange4") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(DEMO_ROUTING_KEY_40);
    }


    /**
     * TOPIC EXCHANGE
     *
     */
    private static final String DEMO_QUEUE_4 = "demoQueue4";

    public static final String DEMO_TOPIC_EXCHANGE_1 = "demoTopicExchange1";

    private static final String DEMO_TOPIC_EXCHANGE_ROUTING_KEY_10 = "demoTopicRoutingKey.#";

    @Bean("demoQueue4")
    public Queue testDemoQueue4(){
        return QueueBuilder.durable(DEMO_QUEUE_4).build();
    }

    @Bean("demoTopicExchange1")
    public TopicExchange testTopicExchange1(){
        return ExchangeBuilder.topicExchange(DEMO_TOPIC_EXCHANGE_1).durable(true).build();
    }

    @Bean
    public Binding demoBindingTopicExchange(@Qualifier("demoQueue4") Queue queue,
                                                      @Qualifier("demoTopicExchange1") TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(DEMO_TOPIC_EXCHANGE_ROUTING_KEY_10);
    }


    /**
     * FANOUT EXCHANGE
     */

    private static final String DEMO_QUEUE_5 = "demoQueue5";

    private static final String DEMO_QUEUE_6 = "demoQueue6";

    public static final String DEMO_FANOUT_EXCHANGE_1 = "demoFanoutExchange1";

    @Bean("demoQueue5")
    public Queue testDemoQueue5(){
        return QueueBuilder.durable(DEMO_QUEUE_5).build();
    }


    @Bean("demoQueue6")
    public Queue testDemoQueue6(){
        return QueueBuilder.durable(DEMO_QUEUE_6).build();
    }

    @Bean("demoFanoutExchange1")
    public FanoutExchange testFanoutExchange1(){
        return ExchangeBuilder.fanoutExchange(DEMO_FANOUT_EXCHANGE_1).durable(true).build();
    }

    @Bean
    public Binding demoBindingFanoutExchange1(@Qualifier("demoQueue5") Queue queue,
                                            @Qualifier("demoFanoutExchange1") FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }

    @Bean
    public Binding demoBindingFanoutExchange2(@Qualifier("demoQueue6") Queue queue,
                                            @Qualifier("demoFanoutExchange1") FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }

}
