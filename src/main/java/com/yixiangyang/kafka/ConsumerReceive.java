package com.yixiangyang.kafka;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public class ConsumerReceive {
    public static void main(String[] args) {
        //1.参数配置:不是每一非得配置
        Properties props = new Properties();
        props.put("bootstrap.servers", "121.41.56.97:9092");
        props.put("auto.commit.interval.ms", "1000");
        //因为每一个消费者必须属于某一个消费者组，所以必须还设置group.id
        props.put("group.id", "test");
//        props.put("enable.auto.commit", "false");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,"false");
//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"latest");
//        props.put("spring.kafka.consumer.auto-offset-reset","latest");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        //2.创建消费者对象，并建立连接
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        //3.设置从"my-topic"主题下拿取数据
        consumer.subscribe(Arrays.asList("my-topic"));

        //4.消费数据
//        while (true) {
            //阻塞时间，从kafka中取出100毫秒的数据，有可能一次性去除0-n条
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(5000));
            //遍历
            try {
                for (ConsumerRecord<String, String> record : records) {
//                System.out.println(record.offset());
//                if(record.offset() == 50){
                    if(Integer.valueOf(record.value())==950){
                        throw new RuntimeException("运行异常");
                    }
                    System.out.println("消费者消费的数据为：" + record.value());
//                }else{
//                    System.out.println("消费者消费的数据为dddd："+record.value());
//                }

                }
            }catch (Exception e){
                System.out.println("这个是异常："+e);
                consumer.commitAsync(new OffsetCommitCallback() {
                    @Override
                    public void onComplete(Map<TopicPartition, OffsetAndMetadata> offsets, Exception exception) {

                        System.out.println("bbbbbbbbbbb");
                        System.out.println(exception.getMessage());
                        System.out.println("这个是提交的偏移量："+offsets.toString());
                    }
                });
            }finally {

            }


                //打印结果
                //System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());
//consumer.close();
//        }
//        consumer.commitAsync();


    }
}
