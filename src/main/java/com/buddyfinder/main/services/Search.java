package com.buddyfinder.main.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
	
	public ArrayList<Activity> getActivities(String activityName, String location, String date){
		Iterable<Activity> x = activityRepository.findAll();
		ArrayList<Activity> list = new ArrayList<>();
		if(activityName.isEmpty() && location.isEmpty()) {
			
			for(Activity i : x) {
				list.add(i);
			}
			System.out.println(list);
			return list;
		}else {
		
		
			for(Activity i : x) {
				if(i.getActivityName().equals(activityName) &&
				i.getLocation().equals(location)
				) {
					list.add(i);
				}
			}
			System.out.println(list);
			return list;
		}
	}

}
