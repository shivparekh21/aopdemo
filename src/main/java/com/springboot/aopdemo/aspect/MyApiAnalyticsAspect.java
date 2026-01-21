package com.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyApiAnalyticsAspect{

    @Before("com.springboot.aopdemo.aspect.AopExpression.forDaoPackageExcludeGetterSetter()") // Using Pointcut declaration
    public void performApiAnalytics() {
        System.out.println(getClass() + ": Performing API analytics");
    }

}
