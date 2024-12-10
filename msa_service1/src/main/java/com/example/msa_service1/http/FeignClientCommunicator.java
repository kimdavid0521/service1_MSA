package com.example.msa_service1.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("service2") //서비스 2로 api 호출한다고 명시
public interface FeignClientCommunicator {

    @RequestMapping(method = RequestMethod.GET, value = "/name/{id}")
    String getName(@PathVariable("id") String id);
}
