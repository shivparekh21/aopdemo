package com.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // Aspect is a Java Class that has collection of related advices Before, After

    @Before("execution(public void com.springboot.aopdemo.*.add*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println(getClass() + ": Executing @Before advice on add*()");
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
