package com.buddyfinder.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buddyfinder.main.models.Friend;

public interface FriendRepository extends JpaRepository<Friend, Integer> {

}
