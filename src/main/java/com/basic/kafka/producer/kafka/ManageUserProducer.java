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

    private final KafkaTemplate<String, UserInfo> kafkaTemplate;

    public void createUserProducer(UserInfo userInfo) {
        Message<UserInfo> message = MessageBuilder
                .withPayload(userInfo)
                .setHeader(KafkaHeaders.TOPIC, CREATE_USER_INFO_TOPIC)
                .build();
        kafkaTemplate.send(message);
        log.info("Producer: Create user info success :: {}", userInfo);
    }

    public void updateUserProducer(UpdateUserInfo updateUserInfo) {
        Message<UpdateUserInfo> message = MessageBuilder
                .withPayload(updateUserInfo)
                .setHeader(KafkaHeaders.TOPIC, UPDATE_USER_INFO_TOPIC)
                .build();
        kafkaTemplate.send(message);
        log.info("Producer: Update user info success :: {}", updateUserInfo);
    }

    public void deleteUserProducer(ReadUserInfo readUserInfo) {
        Message<ReadUserInfo> message = MessageBuilder
                .withPayload(readUserInfo)
                .setHeader(KafkaHeaders.TOPIC, DELETE_USER_INFO_TOPIC)
                .build();
        kafkaTemplate.send(message);
        log.info("Producer: Delete user info success :: {}", readUserInfo);
    }
}
