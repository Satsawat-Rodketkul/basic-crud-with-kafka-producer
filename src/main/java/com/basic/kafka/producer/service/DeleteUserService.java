package com.basic.kafka.producer.service;

import com.basic.kafka.producer.kafka.ManageUserProducer;
import com.basic.kafka.producer.models.ReadUserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeleteUserService {

    private final ManageUserProducer manageUserProducer;

    public ResponseEntity<String> deleteUser(ReadUserInfo readUserInfo) {
        try {
            manageUserProducer.deleteUserProducer(readUserInfo);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return ResponseEntity.ok("Delete user info success");
    }
}