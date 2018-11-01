package com.buddyfinder.main.services;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buddyfinder.main.models.Account;
import com.buddyfinder.main.models.Activity;
import com.buddyfinder.main.repository.ActivityRepository;

@Service
public class UserService {
	
	@Autowired
	ActivityRepository activityRepository;

	public void createEvent(String location, String activity, Date sqlDate, Account account) {
		Activity act = new Activity(location, null, activity, sqlDate, account, null);
		activityRepository.save(act);
	}
}
