package com.example.msa_service1.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class RestTemplateClientCommunicator {

    @Autowired
    private DiscoveryClient discoveryClient;

    public String getName(String id) {

        RestTemplate restTemplate = new RestTemplate(); //restTemplate 객체를 생성하여 IP와 PORT로 직접 호출
        // discoveryClient를 이용하여 서비스 2의 ID와 PORT를 가져와서 api 호출하는 방식
        List<ServiceInstance> instances = discoveryClient.getInstances("service2");

        if (instances.size() == 0) {
            return  null;
        }

        String serviceUrl = String.format("%s/name/%s", instances.get(0).getUri().toString(), id);

        ResponseEntity<String> restExchange =
                restTemplate.exchange(
                        serviceUrl,
                        HttpMethod.GET,
                        null,
                        String.class, id);

        return id + "is" + restExchange.getBody();
    }
}
