package com.basic.kafka.producer.service;

import com.basic.kafka.producer.kafka.ManageUserProducer;
import com.basic.kafka.producer.models.UpdateUserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpdateUserService {

    private final ManageUserProducer manageUserProducer;

    public ResponseEntity<String> updateUser(UpdateUserInfo updateUserInfo) {
        try {
            manageUserProducer.updateUserProducer(updateUserInfo);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return ResponseEntity.ok("Update user info success");
    }
}
