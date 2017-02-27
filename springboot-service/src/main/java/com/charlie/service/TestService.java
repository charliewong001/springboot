package com.charlie.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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
        System.out.println("save user start execute....");
        User u = new User();
        u.setAge(18);
        u.setName("charlie");
        try {
            userMapper.insert(u);
            //            throwException();
            u.setName("udpate");
            userMapper.updateByPrimaryKey(u);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
        }
        System.out.println("save user execute finished");
    }

    private void throwException() {
        throw new RuntimeException();
    }
}
