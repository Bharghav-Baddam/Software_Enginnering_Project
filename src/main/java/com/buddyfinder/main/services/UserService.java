package com.buddyfinder.main.services;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buddyfinder.main.forms.WallForm;
import com.buddyfinder.main.forms.WallPost;
import com.buddyfinder.main.models.Account;
import com.buddyfinder.main.models.Activity;
import com.buddyfinder.main.models.Friend;
import com.buddyfinder.main.models.Wall;
import com.buddyfinder.main.repository.AccountRepository;
import com.buddyfinder.main.repository.ActivityRepository;
import com.buddyfinder.main.repository.FriendRepository;
import com.buddyfinder.main.repository.WallRepository;

@Service
public class UserService {

	@Autowired
	ActivityRepository activityRepository;

	@Autowired
	FriendRepository friendRepository;
	
	@Autowired
	WallRepository wallRepository;

	@Autowired
	AccountRepository accountRepository;
	
	public void declineActivity(String id, Account account) {
		List<Activity> list = activityRepository.findAll();
		System.out.println(id);
		System.out.println(account);
		for(Activity i : list) {
			if(i.getActivityId() == Integer.parseInt(id)) {
				i.setStatus("null");
				i.setAttendedBy(null);
				System.out.println(i);
				activityRepository.save(i);
			}
		}
	}

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

	public ArrayList<Account> getAllFriends(Account sessionAcc) {
		List<Friend> friends = friendRepository.findAll();
		ArrayList<Account> myFriends = new ArrayList<>();
		for (Friend x : friends) {
			if (sessionAcc.getAccountId() == x.getFrom().getAccountId()) {
				myFriends.add(x.getFrom());
			} else if (sessionAcc.getAccountId() == x.getTo().getAccountId()) {
				myFriends.add(x.getTo());
			}
		}

		return myFriends;
	}

	public List<WallPost> getWallPostsForUser(Integer id) {

		Account account = accountRepository.findById(id).get();
		//List<Wall> posts = account.getWallPosts();
		List<Wall> posts = wallRepository.findAll();//wallRepository.findAllByWallPostOn(account);
		List<WallPost> wallPosts = new ArrayList<>();
		for (Wall w : posts) {
			if(w.getWallPostOn().getAccountId().equals(account.getAccountId())) {
				WallPost wp = new WallPost();
				wp.setId(w.getId());
				wp.setContent(w.getText());
				wp.setPostedBy(w.getWallPostBy());
				if (w.getImage() != null && w.getImage().length > 0) {
					wp.setFile(w.getImage());
					wp.setImg(Base64.getEncoder().encodeToString(w.getImage()));
				} else {
					wp.setFile(null);
					wp.setImg(null);
				}
				wallPosts.add(wp);
			}
		}
		return wallPosts;
	}

	public void saveWallPost(WallForm wallForm, Integer postedOnAccId, Account postedBy) {
		Account postedOn = accountRepository.findById(postedOnAccId).get();
		
		Wall wall = new Wall();
		if(wallForm != null) {
			wall.setDate(new Date(1L));
			wall.setText(wallForm.getContent());
			try {
				if(wallForm.getImage() != null && wallForm.getImage().getBytes().length > 0) {
					wall.setImage(wallForm.getImage().getBytes());
				}else {
					wall.setImage(wallForm.getImage().getBytes());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			wall.setWallPostBy(postedBy);
			wall.setWallPostOn(postedOn);
			wallRepository.save(wall);
			accountRepository.saveAndFlush(postedOn);
		}
	}

	public Account getUser(Integer id) {
		Account account = accountRepository.findById(id).get();
		return account;
	}
}
