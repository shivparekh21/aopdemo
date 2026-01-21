package com.springboot.aopdemo.dao;

import com.springboot.aopdemo.Account;

import java.util.*;

public interface AccountDao {
    void addAccount(Account account);

    void setAccountName(String accountName);
    String getAccountName();

    void setServiceCode(String serviceCode);
    String getServiceCode();

    List<Account> findAccounts();

}
