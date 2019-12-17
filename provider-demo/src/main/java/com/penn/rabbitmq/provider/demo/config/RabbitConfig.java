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
}
