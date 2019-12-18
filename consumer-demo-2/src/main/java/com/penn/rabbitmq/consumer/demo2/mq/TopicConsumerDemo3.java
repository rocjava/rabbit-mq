package com.penn.rabbitmq.consumer.demo2.mq;

import com.penn.rabbitmq.consumer.demo2.config.RabbitConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * key是一个数组集合，意思就是可以消费这个队列里面的多种routingKey
 * @author penn
 * @since 2019/12/17
 */
@Component
@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(value = RabbitConfig.DEMO_EXCHANGE_4, type = ExchangeTypes.DIRECT),
        value = @Queue(value = RabbitConfig.DEMO_QUEUE_3),
        key = RabbitConfig.DEMO_ROUTING_KEY_40
))
public class TopicConsumerDemo3 {

    @RabbitHandler
    public void process(String object, Channel channel, @Headers Map<String, Object> headers) throws IOException {

        System.out.println("ConsumerDemo3接收到消息:" + object);
//        Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
//        System.out.println("消息tag:" + deliveryTag);
//        channel.basicAck(deliveryTag, false);

    }
}
