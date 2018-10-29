package com.buddyfinder.main.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buddyfinder.main.models.Account;
import com.buddyfinder.main.models.Activity;
import com.buddyfinder.main.repository.AccountRepository;
import com.buddyfinder.main.repository.ActivityRepository;

@Service
public class Search {
	

	
	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	public ArrayList<Activity> getActivities(String activityName, String location, Date date){
//		Account account1 = new Account("John", "A", "123",
//				"jan@albany", "ss", "test", "admin", new ArrayList<Account>(),
//				new ArrayList<Activity>(), new ArrayList<Activity>()
//				);
//		Account account2 = new Account("Steve", "A", "123",
//				"jan@albany", "ss", "test", "admin", new ArrayList<Account>(),
//				new ArrayList<Activity>(), new ArrayList<Activity>()
//				);
//		
//		Account account3 = new Account("Dog", "A", "123",
//				"jan@albany", "ss", "test", "admin", new ArrayList<Account>(),
//				new ArrayList<Activity>(), new ArrayList<Activity>()
//				);
//		accountRepository.save(account1);
//		accountRepository.save(account2);
//		accountRepository.save(account3);
//		
//		ArrayList<Account> list = new ArrayList<>();
//		
//		list.add(account2);
//		list.add(account3);
//		activityRepository.save(new Activity("New York", "Adirondacks", "Hiking", new Date(1000), account1, list ));
//		activityRepository.save(new Activity("New York", "Adirondacks", "Date", new Date(1000), account3, new ArrayList<Account>() ));
//		activityRepository.save(new Activity("New York", "Adirondacks", "Movies", new Date(1000), account1, new ArrayList<Account>() ));
//		activityRepository.save(new Activity("New York", "Adirondacks", "Hiking", new Date(1000), account2, new ArrayList<Account>() ));
//		activityRepository.save(new Activity("New York", "Adirondacks", "Hiking", new Date(1000), account3, new ArrayList<Account>() ));
//		activityRepository.save(new Activity("New York", "Adirondacks", "Hiking", new Date(1000), account1, new ArrayList<Account>() ));
//		
//		account1.getFriends().add(account2);
//		account1.getFriends().add(account3);
//		accountRepository.save(account1);
//		account1.getFriends().forEach(x -> System.out.println(x.getFirstName()));
//		
//		
		
		Optional<Account> x = accountRepository.findById(1);
		System.out.println(x.orElse(null).getFirstName());
		return null;
	}

}
