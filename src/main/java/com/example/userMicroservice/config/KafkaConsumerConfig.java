package com.example.userMicroservice.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.userMicroservice.domain.offer;

import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;


@Configuration()
public class KafkaConsumerConfig {
    
     /*  @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddres;*/

    public Map<String, Object> consumerConfig() {
        Map<String,Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        //deserialize key
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        //deserialize value
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return props;
    }

     //the second params is depend of what you wanna send
    @Bean()
    public ConsumerFactory<String,String> consumerFactory() {
        var configs = consumerConfig();
        return new DefaultKafkaConsumerFactory<>(configs);
    }


    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String,String>>
        factory(ConsumerFactory<String,String> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String,String> factory = 
        new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }
}
