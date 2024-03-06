package com.basic.kafka.producer.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserInfo {

    private String firstname;
    private String lastname;
    private String email;
}