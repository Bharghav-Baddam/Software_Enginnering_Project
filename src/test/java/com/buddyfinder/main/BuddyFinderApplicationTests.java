package com.buddyfinder.main;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.buddyfinder.main.models.Account;
import com.buddyfinder.main.models.Activity;
import com.buddyfinder.main.models.Advertisement;
import com.buddyfinder.main.models.Friend;
import com.buddyfinder.main.repository.AccountRepository;
import com.buddyfinder.main.repository.AdvertisementRepository;
import com.buddyfinder.main.repository.FriendRepository;
import com.buddyfinder.main.services.Search;
import com.buddyfinder.main.services.UserService;

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
		 
		 @Autowired
		 private UserService userService;
		 
		 @Autowired
		 private AdvertisementRepository advertisementRepository;
		 
		 public void runTest() {
			 Optional option = advertisementRepository.findById(28);
			 Advertisement ad = (Advertisement)option.get();
			 Byte[] BYTE = ad.getImage();
			 byte[] byteArr = new byte[BYTE.length];
			 int j = 0;
			 for(Byte b : BYTE) {
				 byteArr[j++] = b.byteValue();
			 }
			 String url = Base64.getEncoder().encodeToString(byteArr);
			 System.out.println(url);
		 }

		 /*
		  * 
		  * public Account( String firstName, String lastName, String password, String email,
			String securityQuestion, String securityAnswer, String role,List<Account> friends,
			List<Activity> postedActivities, List<Activity> attendedActivities) {
		  */
}
