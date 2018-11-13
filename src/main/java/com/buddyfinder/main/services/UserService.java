package com.buddyfinder.main.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
	
	public ArrayList<Account> getAllFriends(Account sessionAcc) {
		List<Friend> friends = friendRepository.findAll();
		ArrayList<Account> myFriends = new ArrayList<>();
		for(Friend x : friends) {
			if(sessionAcc.getAccountId() == x.getFrom().getAccountId()) {
				myFriends.add(x.getFrom());
			}else if(sessionAcc.getAccountId() == x.getTo().getAccountId()) {
				myFriends.add(x.getTo());
			}
		}
		
		return myFriends;
	}
}
