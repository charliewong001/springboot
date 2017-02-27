package com.charlie.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.charlie.entity.ReturnBean;
import com.charlie.service.TestService;

@RestController
public class TestController {

    @Resource
    private TestService testService;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ReturnBean test() {
        ReturnBean rb = new ReturnBean();
        rb.setCode("0000");
        rb.setMsg("success");
        try {
            testService.saveUser();
        } catch (Exception e) {
            rb.setCode("0001");
            rb.setMsg("error");
        }
        return rb;
    }
}
