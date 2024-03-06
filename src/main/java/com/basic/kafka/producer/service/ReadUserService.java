package com.basic.kafka.producer.service;

import com.basic.kafka.producer.models.ReadUserInfo;
import com.basic.kafka.producer.models.UserInfo;
import com.basic.kafka.producer.properties.WebClientProperty;
import com.basic.kafka.producer.webclient.WebclientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReadUserService {

    private final WebClientProperty webClientProperty;
    private final WebclientService webclientService;

    public ResponseEntity<UserInfo> readUser(ReadUserInfo readUserInfo) {
        UserInfo userInfo;
        try{
            userInfo = webclientService.callReadUserInfo(
                    readUserInfo,
                    webClientProperty.getUrl()
            );
            log.info("Read user info success");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return ResponseEntity.ok().body(userInfo);
    }
}