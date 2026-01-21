package com.springboot.aopdemo.dao;

import com.springboot.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDaoImpl implements AccountDao {

    private String accountName;
    private String serviceCode;

    @Override
    public void addAccount(Account account) {
        System.out.println(account.getClass() + "AccountDaoImpl: Adding an account\n");
    }

    public String getAccountName() {
        System.out.println(getClass() + "in getAccountName()\n");
        return accountName;
    }

    public void setAccountName(String accountName) {
        System.out.println(getClass() + "in setAccountName()\n");
        this.accountName = accountName;
    }

    public String getServiceCode() {
        System.out.println(getClass() + "in getServiceCode()\n");
        return serviceCode;
    }

    @Override
    public List<Account> findAccounts() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("Shiv", "Eddie"));
        accounts.add(new Account("Made", "Platinum"));
        accounts.add(new Account("Luca", "Gold"));
        return accounts;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + "in setServiceCode()\n");
        this.serviceCode = serviceCode;
    }
}
