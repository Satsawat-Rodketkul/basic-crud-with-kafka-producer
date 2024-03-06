package com.basic.kafka.producer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import static com.basic.kafka.producer.kafka.constant.KafkaConstant.*;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public KafkaAdmin.NewTopics createTopic() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name(CREATE_USER_INFO_TOPIC).build(),
                TopicBuilder.name(UPDATE_USER_INFO_TOPIC).build(),
                TopicBuilder.name(DELETE_USER_INFO_TOPIC).build()
        );
    }
}