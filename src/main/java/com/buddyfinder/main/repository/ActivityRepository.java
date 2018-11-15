package com.buddyfinder.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.buddyfinder.main.models.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Integer>{

}
