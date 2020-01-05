package com.yixiangyang.kafka;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProduct {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers","121.41.56.97:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        //2.创建生产者对象，并建立连接

        Producer<String, String> producer = new KafkaProducer<>(props);

        //3.在my-topic主题下，发送消息
        for(int i = 900; i < 1000; i++) {
            producer.send(new ProducerRecord<String, String>("my-topic", Integer.toString(i), Integer.toString(i)));
        }
        //4.关闭
        producer.close();
    }
}
