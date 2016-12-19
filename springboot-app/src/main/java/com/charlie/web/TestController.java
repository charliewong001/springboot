package com.charlie.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.charlie.service.TestService;

@RestController
public class TestController {

    @Resource
    private TestService testService;

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return testService.test();
    }

    @RequestMapping("/save")
    public String save() {
        testService.saveUser();
        return "success";
    }
}
