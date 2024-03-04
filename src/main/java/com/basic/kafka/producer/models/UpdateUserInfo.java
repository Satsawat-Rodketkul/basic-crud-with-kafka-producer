package com.basic.kafka.producer.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserInfo {

    private String field;
    private String value;
}
