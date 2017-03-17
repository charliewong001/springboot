package com.charlie.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(com.charlie.aspect.ServiceLog)")
    public void serviceAspect() {
    }

    @Before("serviceAspect()")
    public void doBefore(JoinPoint joinPoint) {
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        LogEntity logEntity = new LogEntity(joinPoint.getTarget().getClass(),
                ms.getParameterNames(), joinPoint.getArgs(), ms.getName());
        logger.info(
                "*****logAspect invokeClass:{},invokeMethod:{},invokeParams:{}",
                logEntity.getTargetClass().getName(), logEntity.getMethodName(),
                logEntity.getParams());
    }

    @After("serviceAspect")
    public void doAfter(JoinPoint joinPoint) {

    }
}
