package com.example.msa_service1.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RibbonClientCommunicator {

    @Autowired
    RestTemplate restTemplate;

    // IP와 PORT대신 서비스2의 고유명인 Service2로 호출하면 Ribbon이 내부적으로 IP와 PORT를 찾아서 처리
    // 만약 서비스2가 여러개의 인스턴스로 이중화 구성되어있다면 소프트웨어적 로드밸런싱 해줌
    public String getName(String id) {
        ResponseEntity<String> restExchange =
                restTemplate.exchange(
                        "http://service2/name/{id}",
                        HttpMethod.GET,
                        null,
                        String.class, id);

        return id + "is" + restExchange.getBody();
    }
}
