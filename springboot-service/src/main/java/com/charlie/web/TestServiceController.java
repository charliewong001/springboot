package com.charlie.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.charlie.aspect.Log;
import com.charlie.entity.ReturnBean;
import com.charlie.service.TestService;

@RestController
public class TestServiceController {

    @Resource
    private TestService testService;

    @Log
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ReturnBean test(String name, int age) {
        ReturnBean rb = new ReturnBean();
        rb.setCode("0000");
        rb.setMsg("success");
        testService.saveUser(name, age);

        return rb;
    }
}