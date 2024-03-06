package com.basic.kafka.producer.service;

import com.basic.kafka.producer.kafka.ManageUserProducer;
import com.basic.kafka.producer.models.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService {

    private final ManageUserProducer manageUserProducer;

    public ResponseEntity<String> createUser(UserInfo userInfo) {
        try {
            manageUserProducer.createUserProducer(userInfo);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return ResponseEntity.ok("Create user info success");
    }
}