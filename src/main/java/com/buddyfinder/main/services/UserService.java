package com.buddyfinder.main.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buddyfinder.main.models.Account;
import com.buddyfinder.main.models.Activity;
import com.buddyfinder.main.models.Friend;
import com.buddyfinder.main.repository.ActivityRepository;
import com.buddyfinder.main.repository.FriendRepository;

@Service
public class UserService {
	
	@Autowired
	ActivityRepository activityRepository;
	
	@Autowired
	FriendRepository friendRepository;

	public void requestActivity(String id, Account account) {
		List<Activity> list = activityRepository.findAll();
		System.out.println(id);
		System.out.println(account);
		for(Activity i : list) {
			if(i.getActivityId() == Integer.parseInt(id)) {
				i.setStatus("pending");
				i.setAttendedBy(account);
				System.out.println(i);
				activityRepository.save(i);
			}
		}
	}
	

	public void confirmActivity(String id, Account account) {
		
		List<Activity> list = activityRepository.findAll();
		System.out.println(id);
		System.out.println(account);
		for(Activity i : list) {
			if(i.getActivityId() == Integer.parseInt(id)) {
				i.setStatus("confirmed");
				System.out.println(i);
				activityRepository.save(i);
			}
		}
	}
	
	public void acceptRequest(String id, Account account) {
		
	}
	
	public void createEvent(String location, String activity, Date sqlDate, Account account) {
		Activity act = new Activity(location, null, activity, sqlDate, account, null);
		activityRepository.save(act);
	}
	
	public void addFriend(Account sessionAcc, Account friend) {
		Friend friendObj = new Friend();
		friendObj.setFrom(sessionAcc);
		friendObj.setTo(friend);
		friendRepository.save(friendObj);
	}
	

	public ArrayList<String> getLocations(){
		
		
		List<Activity> list = activityRepository.findAll();
		
		TreeSet<String> set = new TreeSet<>();
		list.forEach(x -> {
			set.add(x.getLocation());
		});
		
		ArrayList<String> locations = new ArrayList<>();
		
		set.forEach(x-> locations.add(x));
		return locations;
	}

}
