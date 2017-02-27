package com.charlie.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.charlie.entity.ReturnBean;

@FeignClient("springboot-service")
public interface TestClient {

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    ReturnBean saveUser(@RequestParam(value = "name") String name,
            @RequestParam(value = "age") int age);
}
