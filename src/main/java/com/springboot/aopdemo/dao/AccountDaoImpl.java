package com.springboot.aopdemo.dao;

import com.springboot.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDaoImpl implements AccountDao {
    @Override
    public void addAccount(Account account) {
        System.out.println(account.getClass() + "AccountDaoImpl: Adding an account");
    }
}
