package com.buddyfinder.main;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.buddyfinder.main.models.Account;
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
			
		 
		 public void runTest() {
		 search.getActivities("Hiking", "test", new Date(1000));
		 }

}
