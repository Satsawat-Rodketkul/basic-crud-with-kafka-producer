package com.basic.kafka.producer.service;

import com.basic.kafka.producer.models.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReadUserService {

    public ResponseEntity<UserInfo> readUser() {
        try{

        } catch (Exception ex) {
            throw new RuntimeException("ex");
        }
        return ResponseEntity.ok().body();
    }
}
