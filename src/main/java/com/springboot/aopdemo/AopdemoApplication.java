package com.springboot.aopdemo;

import com.springboot.aopdemo.dao.AccountDao;
import com.springboot.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao, MembershipDAO membershipDao) {
		return runner -> {
			demoTheBeforeAdvice(accountDao, membershipDao);

		};
	}

	private void demoTheBeforeAdvice(AccountDao accountDao, MembershipDAO membershipDao) {

		accountDao.addAccount(new Account());

		membershipDao.addMemberAccount();
	}


}
