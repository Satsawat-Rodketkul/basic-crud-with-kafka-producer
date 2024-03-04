package com.basic.kafka.producer.controller;

import com.basic.kafka.producer.models.ReadUserInfo;
import com.basic.kafka.producer.models.UpdateUserInfo;
import com.basic.kafka.producer.models.UserInfo;
import com.basic.kafka.producer.service.CreateUserService;
import com.basic.kafka.producer.service.DeleteUserService;
import com.basic.kafka.producer.service.ReadUserService;
import com.basic.kafka.producer.service.UpdateUserService;
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
    private final ReadUserService readUserService;
    private final UpdateUserService updateUserService;
    private final DeleteUserService deleteUserService;

    @PostMapping("/create")
    public ResponseEntity<String> createUserInfo(@RequestBody UserInfo userInfo) {
        return createUserService.createUser(userInfo);
    }

    @PostMapping("/read")
    public ResponseEntity<UserInfo> readUserInfo(@RequestBody ReadUserInfo readUserInfo) {
        return readUserService.readUser(readUserInfo);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateUserInfo(@RequestBody UpdateUserInfo updateUserInfo) {
        return updateUserService.updateUser(updateUserInfo);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteUserInfo(@RequestBody ReadUserInfo readUserInfo) {
        return deleteUserService.deleteUser(readUserInfo);
    }
}
