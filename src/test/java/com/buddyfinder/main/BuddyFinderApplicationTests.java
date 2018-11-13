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
import com.buddyfinder.main.models.Friend;
import com.buddyfinder.main.repository.AccountRepository;
import com.buddyfinder.main.repository.FriendRepository;
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
		 
		 @Autowired
		 private FriendRepository friendRepository;
		 
		 public void runTest() {
			 Account account1 = new Account("John", "An", "123456", "jan2@albany.edu", "123", "", "user",
					 new ArrayList<Activity>(), new ArrayList<Activity>() );
			 Account account2 = new Account("John", "An", "123456", "jan1@albany.edu", "123", "", "user",
					 new ArrayList<Activity>(), new ArrayList<Activity>() );
			 Account account3 = new Account("John", "An", "123456", "jan3@albany.edu", "123", "", "user",
					 new ArrayList<Activity>(), new ArrayList<Activity>() );
			 accountRepository.save(account1);
			 accountRepository.save(account2);
			 accountRepository.save(account3);
			 Friend friend = new Friend();
			 
			 friend.setFrom(account1);
			 friend.setTo(account2);
			 
			 friendRepository.save(friend);
			 
		 }

		 /*
		  * 
		  * public Account( String firstName, String lastName, String password, String email,
			String securityQuestion, String securityAnswer, String role,List<Account> friends,
			List<Activity> postedActivities, List<Activity> attendedActivities) {
		  */
}
