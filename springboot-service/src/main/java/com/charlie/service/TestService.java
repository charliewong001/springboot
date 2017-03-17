package com.charlie.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.charlie.aspect.ServiceLog;
import com.charlie.dao.UserMapper;
import com.charlie.model.User;

@Service("testService")
public class TestService {

    @Resource
    private UserMapper userMapper;

    @ServiceLog(description = "haha")
    public String test() {
        return "test";
    }

    @ServiceLog(description = "haha")
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUser(String name, int age) {
        User u = new User();
        u.setAge(age);
        u.setName(name);
        try {
            userMapper.insert(u);
            //            throwException();
            //            u.setName("udpate");
            //            userMapper.updateByPrimaryKey(u);
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
