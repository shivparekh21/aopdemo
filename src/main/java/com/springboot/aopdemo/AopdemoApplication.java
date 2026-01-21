package com.springboot.aopdemo;

import com.springboot.aopdemo.dao.AccountDao;
import com.springboot.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao, MembershipDAO membershipDao) {
		return runner -> {
//			demoTheBeforeAdvice(accountDao, membershipDao);
//			demoAfterReturningAdvice(accountDao);
			demoTheAfterThrowingAdvice(accountDao);
		};
	}

	private void demoTheAfterThrowingAdvice(AccountDao accountDao) {
		List<Account> myAccounts = null;
		try{
			boolean trueWire = true;
			accountDao.findAccounts(trueWire);
		}catch (Exception e){
			System.out.println("\n\nMain Program: Caught exception: " + e);
		}

		System.out.println("\n\nMain Program: AfterThrowingAdvice");
		System.out.println("----------------------------");
		for (Account account : myAccounts) {
			System.out.println(account);
		}
	}

	private void demoAfterReturningAdvice(AccountDao accountDao) {
		List<Account> myAccounts = accountDao.findAccounts();

		System.out.println("\n\nMain Program: AfterReturningAdvice");
		System.out.println("----------------------------");
		for (Account account : myAccounts) {
			System.out.println(account);
		}
	}

	private void demoTheBeforeAdvice(AccountDao accountDao, MembershipDAO membershipDao) {

		accountDao.addAccount(new Account("John", "Silver"));
		membershipDao.addMemberAccount();

		accountDao.setAccountName("foobar");
		accountDao.setServiceCode("silver");

		System.out.println("\n" + accountDao.getAccountName() + "\n");
		System.out.println("\n" + accountDao.getServiceCode() + "\n");
	}




}
