package com.charlie.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.charlie.dao.UserMapper;
import com.charlie.model.User;

@Service("testService")
public class TestService {

    @Resource
    private UserMapper userMapper;

    public String test() {
        return "test";
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUser() {
        User u = new User();
        u.setAge(18);
        u.setName("charlie");
        userMapper.insert(u);
    }
}
