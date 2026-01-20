package com.springboot.aopdemo.dao;

import com.springboot.aopdemo.Account;
import org.springframework.stereotype.Component;

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

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + "in setServiceCode()\n");
        this.serviceCode = serviceCode;
    }
}
