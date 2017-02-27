package com.charlie.web;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.charlie.entity.ReturnBean;

@RestController
public class TestController {

    @Resource
    RestTemplate restTemplate;

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }

    @RequestMapping("/save")
    @ResponseBody
    public String save() {
        ResponseEntity<ReturnBean> response = restTemplate.getForEntity(
                "http://SPRINGBOOT-SERVICE/test", ReturnBean.class);
        ReturnBean rb = response.getBody();
        return rb.toString();
    }
}
