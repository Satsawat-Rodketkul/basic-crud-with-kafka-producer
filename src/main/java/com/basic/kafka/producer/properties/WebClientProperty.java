package com.basic.kafka.producer.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "web-client")
@Getter
@Setter
public class WebClientProperty {

    private String url;

}
