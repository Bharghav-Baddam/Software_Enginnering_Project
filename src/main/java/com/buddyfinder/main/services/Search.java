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

	public ArrayList<Activity> getActivities(String activityName, String location, Date date){
		Iterable<Activity> x = activityRepository.findAll();
		ArrayList<Activity> list = new ArrayList<>();
		//if all fields are empty
		if(activityName.isEmpty() && location.isEmpty() && date == null) {
			
			for(Activity i : x) {
				list.add(i);
			}
			System.out.println(list);
			return list;
		
		}
		//if only date is available
		else if(activityName.isEmpty() && location.isEmpty() && date != null){
		
		
			for(Activity i : x) {
				if(i.getDate().equals(date)
				) {
					list.add(i);
				}
			}
			System.out.println(list);
			return list;
		}
		//if only location is available
		else if(activityName.isEmpty() && !location.isEmpty() && date == null){
			
			
			for(Activity i : x) {
				if(i.getLocation().equals(location)
				) {
					list.add(i);
				}
			}
			System.out.println(list);
			return list;
		}
		//if only activity is available
		else if(!activityName.isEmpty() && location.isEmpty() && date == null){

			for(Activity i : x) {
				if(i.getActivityName().equals(activityName)
				) {
					list.add(i);
				}
			}
			System.out.println(list);
			return list;
		}
		//if activity and location are available
		else if(!activityName.isEmpty() && !location.isEmpty() && date == null) {
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
		//if activity and date are available
		else if(!activityName.isEmpty() && location.isEmpty() && date != null) {
			for(Activity i : x) {
				if(i.getActivityName().equals(activityName) &&
						i.getDate().equals(date)
				) {
					list.add(i);
				}
			}
			System.out.println(list);
			return list;
		}
		//if location and date are available
		else if(activityName.isEmpty() && !location.isEmpty() && date != null) {
			for(Activity i : x) {
				if(i.getActivityName().equals(activityName) &&
						i.getDate().equals(date)
				) {
					list.add(i);
				}
			}
			System.out.println(list);
			return list;
		}
		
		else {
			for(Activity i : x) {
				if(i.getActivityName().equals(activityName) &&
						i.getLocation().equals(location) && 
						i.getDate().equals(date)
				) {
					list.add(i);
				}
			}
			System.out.println(list);
			return list;
		}
	}
	
	public ArrayList<Activity> getMyActivity(Account account) {
		ArrayList<Activity> activities = getActivities("", "", null);
		ArrayList<Activity> myActivities = new ArrayList<>();
		for (Activity a : activities) {
			if (account.getAccountId().equals(a.getPostedBy().getAccountId())) {
				myActivities.add(a);
			}
		}
		return myActivities;
	}

}
