package com.charlie.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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

    @Pointcut("@annotation(com.charlie.aspect.Log)")
    public void invokeLogAspect() {
    }

    private ThreadLocal<LogEntity> t = new ThreadLocal<LogEntity>();

    @Before("invokeLogAspect()")
    public void doBefore(JoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        LogEntity logEntity = new LogEntity(joinPoint.getTarget().getClass(),
                ms.getParameterNames(), joinPoint.getArgs(), ms.getName());
        logEntity.setStartTime(start);
        t.set(logEntity);
        Logger logger = LoggerFactory.getLogger(logEntity.getTargetClass());
        logger.info("*****logAspect start,METHOD:{},PARAMS:{}",
                logEntity.getTargetClass().getName(), logEntity.getMethodName(),
                logEntity.getParams());

    }

    @AfterReturning(pointcut = "invokeLogAspect()", returning = "ret")
    public void afterReturn(JoinPoint joinPoint, Object ret) {
        LogEntity logEntity = t.get();
        Logger logger = LoggerFactory.getLogger(logEntity.getTargetClass());
        logger.info("*****logAspect end,METHOD:{},RETURN:{},USETIME:{}",
                logEntity.getTargetClass().getName(), logEntity.getMethodName(),
                ret, System.currentTimeMillis() - logEntity.getStartTime());
    }

    /**
     * 使用@Around前端无法获取到返回的JSON
     */
    //  @Around("invokeLogAspect()")
    //  public void doAround(ProceedingJoinPoint joinPoint) throws Throwable{
    //      long start = System.currentTimeMillis();
    //      MethodSignature ms = (MethodSignature) joinPoint.getSignature();
    //      LogEntity logEntity = new LogEntity(joinPoint.getTarget().getClass(), ms.getParameterNames(),
    //              joinPoint.getArgs(), ms.getName());
    //      logger.info("*****logAspect start CLASS:{},METHOD:{},PARAMS:{}",
    //              logEntity.getTargetClass().getName(), logEntity.getMethodName(), logEntity.getParams());
    //      Object ret = joinPoint.proceed(joinPoint.getArgs());
    //      logger.info("*****logAspect end CLASS:{},METHOD:{},RETURN:{},USETIME:{}",
    //              logEntity.getTargetClass().getName(), 
    //              logEntity.getMethodName(),
    //              ret,
    //              System.currentTimeMillis() - start);
    //  }
}
