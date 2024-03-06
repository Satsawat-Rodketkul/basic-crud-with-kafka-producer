package com.basic.kafka.producer.webclient;

import com.basic.kafka.producer.models.ReadUserInfo;
import com.basic.kafka.producer.models.UserInfo;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WebclientService {

    private final WebClient webClient;

    public WebclientService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public UserInfo callReadUserInfo(ReadUserInfo readUserInfo, String url) {
        return webClient.post()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(readUserInfo)
                .retrieve()
                .bodyToMono(UserInfo.class)
                .block();
    }
}