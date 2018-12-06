package com.buddyfinder.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buddyfinder.main.models.Activity;
import com.buddyfinder.main.models.Advertisement;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Integer>{

}
