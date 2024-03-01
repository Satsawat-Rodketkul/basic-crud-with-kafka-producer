package com.basic.kafka.producer.controller;

import com.basic.kafka.producer.models.UserInfo;
import com.basic.kafka.producer.service.CreateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/manage/v1/user")
public class ManageUserInfoController {

    private final CreateUserService createUserService;

    @PostMapping("/create")
    public ResponseEntity<String> createUserInfo(@RequestBody UserInfo userInfo) {
        return createUserService.createUser(userInfo);
    }
}
