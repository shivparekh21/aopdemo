package com.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// This class is used to hold all of our pointcut expressions for easy maintenance
// No need of @Aspect as it hold only pointcut declarations
@Aspect
@Component
public class AopExpression {

    // Pointcut declaration can be reused in multiple advices by just referring to the method name
    @Pointcut("execution(* com.springboot.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.springboot.aopdemo.dao..get*(..))")
    public void getter() {}
    @Pointcut("execution(* com.springboot.aopdemo.dao..set*(..))")
    public void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageExcludeGetterSetter() {}

}
