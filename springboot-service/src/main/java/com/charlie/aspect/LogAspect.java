package com.charlie.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(com.charlie.aspect.Log)")
    public void invokeLogAspect() {
    }

    //    @Before("invokeLogAspect()")
    //    public void doBefore(JoinPoint joinPoint) {
    //        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
    //        LogEntity logEntity = new LogEntity(joinPoint.getTarget().getClass(),
    //                ms.getParameterNames(), joinPoint.getArgs(), ms.getName());
    //        logger.info(
    //                "*****logAspect invokeClass:{},invokeMethod:{},invokeParams:{}",
    //                logEntity.getTargetClass().getName(), logEntity.getMethodName(),
    //                logEntity.getParams());
    //    }
    //
    //    @After("invokeLogAspect()")
    //    public void doAfter(JoinPoint joinPoint) {
    //
    //    }

    @Around("invokeLogAspect()")
    public void doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        LogEntity logEntity = new LogEntity(joinPoint.getTarget().getClass(),
                ms.getParameterNames(), joinPoint.getArgs(), ms.getName());
        logger.info(
                "*****logAspect invokeClass:{},invokeMethod:{} START,invokeParams:{}",
                logEntity.getTargetClass().getName(), logEntity.getMethodName(),
                logEntity.getParams());
        Object ret = joinPoint.proceed(logEntity.getParamValues());
        logger.info(
                "*****logAspect invokeClass:{},invokeMethod:{} END,returnValue={}",
                logEntity.getTargetClass().getName(), logEntity.getMethodName(),
                ret);
    }
}
