package com.buddyfinder.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buddyfinder.main.models.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
