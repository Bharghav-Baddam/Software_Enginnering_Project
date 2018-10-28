package com.buddyfinder.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buddyfinder.main.models.Role;
import com.buddyfinder.main.models.User_Act_Mapping;

public interface User_Act_MappingRepository extends JpaRepository<User_Act_Mapping, Integer> {

}
