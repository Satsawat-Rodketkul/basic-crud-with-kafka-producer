package com.basic.kafka.producer.kafka;

import com.basic.kafka.producer.models.ReadUserInfo;
import com.basic.kafka.producer.models.UpdateUserInfo;
import com.basic.kafka.producer.models.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import static com.basic.kafka.producer.kafka.constant.KafkaConstant.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class ManageUserProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void createUserProducer(UserInfo userInfo) {
        var message = buildPayloadMessage(userInfo, CREATE_USER_INFO_TOPIC, KAFKA_HEADER_TYPE_VALUE_CREATE);
        kafkaTemplate.send(message);
        log.info("Producer: Create user info success :: {}", userInfo);
    }

    public void updateUserProducer(UpdateUserInfo updateUserInfo) {
        var message = buildPayloadMessage(updateUserInfo, UPDATE_USER_INFO_TOPIC, KAFKA_HEADER_TYPE_VALUE_UPDATE);
        kafkaTemplate.send(message);
        log.info("Producer: Update user info success :: {}", updateUserInfo);
    }

    public void deleteUserProducer(ReadUserInfo readUserInfo) {
        var message = buildPayloadMessage(readUserInfo, DELETE_USER_INFO_TOPIC, KAFKA_HEADER_TYPE_VALUE_DELETE);
        kafkaTemplate.send(message);
        log.info("Producer: Delete user info success :: {}", readUserInfo);
    }

    private <T> Message<T> buildPayloadMessage(T payloadBody, String topic, String type) {
        return MessageBuilder
                .withPayload(payloadBody)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .setHeader(KAFKA_HEADER_TYPE_KEY, type)
                .build();
    }
}
