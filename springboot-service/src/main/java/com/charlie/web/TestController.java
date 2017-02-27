package com.charlie.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.charlie.service.TestService;

@RestController
public class TestController {

    @Resource
    private TestService testService;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test() {
        testService.saveUser();
        return "SUCCESS";
    }
}
