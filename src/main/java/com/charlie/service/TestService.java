package com.charlie.service;

import org.springframework.stereotype.Service;

@Service("testService")
public class TestService {
    public String test() {
        return "test";
    }
}
