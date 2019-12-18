package com.penn.rabbitmq.consumer.demo1.mq;

import com.penn.rabbitmq.consumer.demo1.config.RabbitConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author penn
 * @since 2019/12/17
 */
@Component
@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(value = RabbitConfig.DEMO_TOPIC_EXCHANGE_1, type = ExchangeTypes.TOPIC),
        value = @Queue(value = RabbitConfig.DEMO_QUEUE_4),
        key = RabbitConfig.DEMO_TOPIC_EXCHANGE_ROUTING_KEY_10
))
public class TopicConsumerDemo4 {

    @RabbitHandler
    public void process(String object, Channel channel, @Headers Map<String, Object> headers) throws IOException {

        System.out.println("ConsumerDemo3接收到消息:" + object);
//        Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
//        System.out.println("消息tag:" + deliveryTag);
//        channel.basicAck(deliveryTag, false);

    }
}
