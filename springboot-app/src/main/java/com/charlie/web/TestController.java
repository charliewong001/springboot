package com.charlie.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
        restTemplate.getForEntity("http://SPRINGBOOT-SERVICE/test",
                String.class);
        return "success";
    }
}
