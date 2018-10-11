package com.buddyfinder.main.repository;


import org.springframework.data.repository.CrudRepository;

import com.buddyfinder.main.models.Friend;

public interface FriendRepository extends CrudRepository<Friend, String>{
	
	
}

