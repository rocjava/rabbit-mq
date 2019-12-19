RABBITMQ优势  
1、支持持久化;  
2、消息可以手动确认，保证可靠性;  
3、负载均衡，多个消费者会默认轮训消费队列里的消息;  
4、多种交换机模式，有直连，有topic，有fanout;  
5、支持routingKey匹配，可以指定哪几种routingKey消息可以被发送到队列;  
6、消费者监听器也比较灵活，既可以消费某个队列，又可以值消费某个队列里面某几种routingKey消息;  
****
配置  
手动确认，保障消息可靠性;  
acknowledge-mode: manual  
在消费异常后，既可以不一直刷新日志，又可以在重启后再次消费;  
default-requeue-rejected: false