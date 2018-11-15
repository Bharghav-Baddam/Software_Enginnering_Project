package com.buddyfinder.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buddyfinder.main.models.Account;
import com.buddyfinder.main.models.Wall;

public interface WallRepository  extends JpaRepository<Wall, Integer> {

	List<Wall> findAllByWallPostOn(Account acc);

}
