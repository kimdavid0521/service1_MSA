package com.example.msa_service1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// 유레카 서버에 등록된 서비스 목록을 가져오는 코드
@Service
public class DiscoveryService {

    @Autowired
    private DiscoveryClient discoveryClient;

    public List getServices() {
        List<String> services = new ArrayList<String>();

        discoveryClient.getServices().forEach(serviceName -> {
            discoveryClient.getInstances(serviceName).forEach(instance -> {
                services.add( String.format("%s:%s", serviceName, instance.getUri()));
            });
        });
        return services;
    }

}

