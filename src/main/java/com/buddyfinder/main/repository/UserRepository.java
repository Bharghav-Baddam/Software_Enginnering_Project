package com.buddyfinder.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buddyfinder.main.models.User;

public interface UserRepository extends JpaRepository<User, Long>{


	User findByUsername(String username);
}
