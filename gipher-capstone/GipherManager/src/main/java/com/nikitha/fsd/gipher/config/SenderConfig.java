package com.nikitha.fsd.gipher.config;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.nikitha.fsd.gipher.model.Gif;


@Configuration
public class SenderConfig {

    @Value(value = "${spring.kafka.bootstrap-address}")
    private String bootstrapAddress;

    @Bean
    public ProducerFactory<String,Gif> producerFactory() {
        Map<String,Object> configProperties = new HashMap<>();
        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapAddress);
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(configProperties);
    }

    @Bean
    public KafkaTemplate<String,Gif> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

//
//  @Bean
//  public Sender sender() {
//    return new Sender();
//  }
}
