package com.nikitha.fsd.gipher.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;


@Configuration
public class Sender {

    @Value(value = "${spring.kafka.bootstrap-address}")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configurations = new HashMap<>();
        configurations.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapAddress);

        return new KafkaAdmin(configurations);
    }

    @Bean
    public NewTopic topic() {
        return new NewTopic("test_topic",1,(short) 1);
    }

}
