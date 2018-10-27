package com.buddyfinder.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buddyfinder.main.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
}
