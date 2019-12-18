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

    public static final String DEMO_QUEUE = "demoQueue";

    public static final String DEMO_EXCHANGE = "demoExchange";

    public static final String DEMO_ROUTING_KEY = "demoRoutingKey";

    public static final String DEMO_ROUTING_KEY_1 = "demoRoutingKey1";

    public static final String DEMO_ROUTING_KEY_2 = "demoRoutingKey2";

    /**
     * 一个queue绑定多个routingKey到exchange
     */

    @Bean("demoQueue")
    public Queue testDemoQueue(){
        return QueueBuilder.durable(DEMO_QUEUE).build();
    }

    @Bean("demoExchange")
    public DirectExchange testDirectExchange(){
        return ExchangeBuilder.directExchange(DEMO_EXCHANGE).durable(true).build();
    }

    @Bean
    public Binding demoBinding(@Qualifier("demoQueue") Queue queue,
                                       @Qualifier("demoExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(DEMO_ROUTING_KEY);
    }

    @Bean
    public Binding demoBinding1(@Qualifier("demoQueue") Queue queue,
                               @Qualifier("demoExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(DEMO_ROUTING_KEY_1);
    }

    /**
     * 一个queue绑定到多个exchange
     */
    public static final String DEMO_EXCHANGE_1 = "demoExchange1";

    @Bean("demoExchange1")
    public DirectExchange testDirectExchange1(){
        return ExchangeBuilder.directExchange(DEMO_EXCHANGE_1).durable(true).build();
    }

    @Bean
    public Binding demoBindingExchange(@Qualifier("demoQueue") Queue queue,
                               @Qualifier("demoExchange1") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(DEMO_ROUTING_KEY);
    }

    /**
     * 一个queue绑定到DirectExchange，但是指定空字符串routingKey
     */

    public static final String DEMO_EXCHANGE_3 = "demoExchange3";
    @Bean("demoExchange3")
    public DirectExchange testDirectExchange3(){
        return ExchangeBuilder.directExchange(DEMO_EXCHANGE_3).durable(true).build();
    }

    @Bean
    public Binding demoBindingExchangeWithoutRoutingKey(@Qualifier("demoQueue") Queue queue,
                                       @Qualifier("demoExchange3") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("");
    }

    /**
     * 一个exchange绑定多个queue
     */
    public static final String DEMO_QUEUE_1 = "demoQueue1";

    @Bean("demoQueue1")
    public Queue testDemoQueue1(){
        return QueueBuilder.durable(DEMO_QUEUE_1).build();
    }

    @Bean
    public Binding demoBindingNExchange2OneQueue(@Qualifier("demoQueue1") Queue queue,
                                       @Qualifier("demoExchange1") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(DEMO_ROUTING_KEY);
    }

}
