package com.charlie.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.charlie.api.TestClient;
import com.charlie.entity.ReturnBean;

@RestController
public class TestAppController {

    @Resource
    private TestClient testClient;

    @RequestMapping("/save")
    @ResponseBody
    public String save() {
        ReturnBean rb = testClient.saveUser("hello", 18);

        return rb.toString();
    }
}
