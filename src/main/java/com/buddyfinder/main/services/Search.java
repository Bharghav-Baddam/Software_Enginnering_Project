package com.buddyfinder.main.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buddyfinder.main.models.Friend;
import com.buddyfinder.main.repository.FriendRepository;

@Service
public class Search {
	

	private Map<String, Friend> friends = new HashMap<>();
	
	@Autowired
	private FriendRepository friendRepository;
	

	
	public List<Friend> getFriends() {
		ArrayList<Friend> list = new ArrayList<>();
//		friendRepository.save(new Friend("1", "John", "New York", new Date((long) 123.23)));
//		friendRepository.save(new Friend("2","Bharghav", "New York", new Date((long) 123.23)));
//		friendRepository.save(new Friend("3","Rutvik", "New York", new Date((long) 123.23)));
//		friendRepository.save(new Friend("4","Zhenjiang", "New York", new Date((long) 123.23)));
//		friendRepository.save(new Friend("5","Ansel", "New York", new Date((long) 123.23)));
//		friendRepository.save(new Friend("6","Bharvee", "New York", new Date((long) 123.23)));
//		friendRepository.save(new Friend("7","Chengwang", "New York", new Date((long) 123.23)));
		friendRepository.findAll().forEach(x-> list.add(x));
		
		return list;
	}
	
	public List<Friend> getFriends(String location, String activity, String date){
		
		friendRepository.save(new Friend("1", "John", "New York", new Date((long) 123.23),"Hiking"));
		friendRepository.save(new Friend("2","Bharghav", "New York", new Date((long) 123.23),"Running"));
		friendRepository.save(new Friend("3","Rutvik", "New York", new Date((long) 123.23),"Date"));
		friendRepository.save(new Friend("4","Zhenjiang", "New York", new Date((long) 123.23),"Watching Movie"));
		friendRepository.save(new Friend("5","Ansel", "New York", new Date((long) 123.23),"Getting Dinner"));
		friendRepository.save(new Friend("6","Bharvee", "New York", new Date((long) 123.23),"Hiking"));
		friendRepository.save(new Friend("7","Chengwang", "New York", new Date((long) 123.23),"Hiking"));
		
		Iterable<Friend> friends = friendRepository.findAll();
		ArrayList<Friend> listOfFriends = new ArrayList<>();
		friends.forEach(x->{
			if(x.getActivity().equals(activity)) {
				listOfFriends.add(x);
		}
		});
		return listOfFriends;
	}
}
