package com.example.msa_service1.controller;

import com.example.msa_service1.service.DiscoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiscoveryController {
    @Autowired
    DiscoveryService discoveryService;
    // 유레카 서버에 등록된 서비스 목록을 가져오는 api
    @GetMapping("/services")
    public List<String> services() {
        return discoveryService.getServices();
    }


    // restTemplate 적용
    @GetMapping("/resttemplate/{id}")
    public String resttemplate(@PathVariable("id") String id) {
        return discoveryService.resttemplate(id);
    }
}
