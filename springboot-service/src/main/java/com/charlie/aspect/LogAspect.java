package com.charlie.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.charlie.aspect.ServiceLog)")
    public void serviceAspect(JoinPoint joinPoint) {
        Class clazz = joinPoint.getClass();
        Object[] params = joinPoint.getArgs();
    }

    @Before("serviceAspect()")
    public void doBefore() {
        System.out.println("serviceAspect....");
    }
}
