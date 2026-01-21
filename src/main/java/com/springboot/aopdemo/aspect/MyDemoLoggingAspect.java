package com.springboot.aopdemo.aspect;

import com.springboot.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.*;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect{
    // Aspect is a Java Class that has collection of related advices Before, After

//    @Before("execution(* com.springboot.aopdemo.dao.*.*(..))")
//    @Before("forDaoPackage()") // Using Pointcut declaration
    @Before("com.springboot.aopdemo.aspect.AopExpression.forDaoPackageExcludeGetterSetter()") // Using Pointcut declaration
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println(getClass() + ": Executing @Before advice on *()");

        // Display method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // Display method arguments
        Object[] args = joinPoint.getArgs();
        for (Object tempArg : args) {
            System.out.println(tempArg);

            if(tempArg instanceof Account){
                // downcast and print Account specific stuff
                Account account = (Account) tempArg;
                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            }
        }
    }

    @AfterReturning(
            pointcut = "execution(* com.springboot.aopdemo.dao.AccountDao.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        // Print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n----->>> Executing @AfterReturning on method: " + method);

        // Print out the results of the method call
        System.out.println("\n----->>> Result is: " + result);
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
