package com.example.msa_service1.service;


import com.example.msa_service1.http.RestTemplateClientCommunicator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// 유레카 서버에 등록된 서비스 목록을 가져오는 코드
@Service
@Slf4j
public class DiscoveryService {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    RestTemplateClientCommunicator restTemplateClientCommunicator;

    public List getServices() {
        List<String> services = new ArrayList<String>();

        discoveryClient.getServices().forEach(serviceName -> {
            discoveryClient.getInstances(serviceName).forEach(instance -> {
                services.add( String.format("%s:%s", serviceName, instance.getUri()));
            });
        });
        return services;
    }

    // restTemplate 적용
    public String resttemplate(String id) {
        log.info("restTemplateClientCommunicator로 통신");
        return restTemplateClientCommunicator.getName(id);
    }

}

