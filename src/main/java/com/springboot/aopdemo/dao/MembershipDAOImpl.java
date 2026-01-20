package com.springboot.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public void addMemberAccount() {
        System.out.println(getClass() + "MembershipDAOImpl: Adding a membership account\n");
    }
}
