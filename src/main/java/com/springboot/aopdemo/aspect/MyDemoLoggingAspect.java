package com.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // Aspect is a Java Class that has collection of related advices Before, After

    // Pointcut declaration can be reused in multiple advices by just referring to the method name
    @Pointcut("execution(* com.springboot.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("execution(* com.springboot.aopdemo.dao..get*(..))")
    private void getter() {}
    @Pointcut("execution(* com.springboot.aopdemo.dao..set*(..))")
    private void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageExcludeGetterSetter() {}


//    @Before("execution(* com.springboot.aopdemo.dao.*.*(..))")
//    @Before("forDaoPackage()") // Using Pointcut declaration
    @Before("forDaoPackageExcludeGetterSetter()") // Using Pointcut declaration
    public void beforeAddAccountAdvice() {
        System.out.println(getClass() + ": Executing @Before advice on *()");
    }

    @Before("forDaoPackageExcludeGetterSetter()") // Using Pointcut declaration
    public void performApiAnalytics() {
        System.out.println(getClass() + ": Performing API analytics");
    }






//    @Before("execution(public void add*())")
//    @Before("execuation(public void com.springboot.aopdemo.dao.AccountDao.addAccount())")
//    @Before("execution( void add*())")
//    @Before("execution( * add*())")
//    () no arguments
//    (*) one argument of any type
//    (..) zero or more arguments of any type
//    (com.springboot.aopdemo.dao.Account) one argument of type Account
//    (* com.springboot.aopdemo.dao.*.*(..)) any return type, any class in dao package, any method with any arguments
//    (* com.springboot.aopdemo.dao.*.*(com.springboot.aopdemo.dao.Account, ..))  first argument of type Account, then zero or more arguments of any type
//     @Before("execution(public void com.springboot.aopdemo..add*(..))") // .. means any class within the package and its sub-packages to avoid Error

}
