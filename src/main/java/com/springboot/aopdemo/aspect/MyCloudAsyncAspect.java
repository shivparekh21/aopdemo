package com.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(13)
public class MyCloudAsyncAspect{

    @Before("com.springboot.aopdemo.aspect.AopExpression.forDaoPackageExcludeGetterSetter()") // Using Pointcut declaration
    public void logToCloudAsync() {
        System.out.println(getClass() + ": Logging to cloud in async fashion");
    }

}
