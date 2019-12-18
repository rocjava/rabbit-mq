package com.penn.rabbitmq.consumer.demo3.mq;

import com.penn.rabbitmq.consumer.demo3.config.RabbitConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author penn
 * @since 2019/12/17
 */
@Component
@RabbitListener(queues = RabbitConfig.DEMO_QUEUE_2)
public class ConsumerDemo2 {

    @RabbitHandler
    public void process(String object, Channel channel, @Headers Map<String, Object> headers) throws IOException {

        System.out.println("ConsumerDemo2接收到消息:" + object);
//        Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
//        System.out.println("消息tag:" + deliveryTag);
//        channel.basicAck(deliveryTag, false);

    }
}
