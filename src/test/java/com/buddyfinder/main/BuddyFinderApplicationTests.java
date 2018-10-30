package com.buddyfinder.main;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.buddyfinder.main.models.Account;
import com.buddyfinder.main.models.Activity;
import com.buddyfinder.main.repository.AccountRepository;
import com.buddyfinder.main.services.Search;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuddyFinderApplicationTests {

	@Test
	public void contextLoads() {
		this.runTest();
	}
	
	    // autowire beans and perform tests with @Test 
		 @Autowired
		 private Search search;
			
		 @Autowired
		 private AccountRepository accountRepository;
		 
		 public void runTest() {

			
		 }

		 /*
		  * 
		  * public Account( String firstName, String lastName, String password, String email,
			String securityQuestion, String securityAnswer, String role,List<Account> friends,
			List<Activity> postedActivities, List<Activity> attendedActivities) {
		  */
}
