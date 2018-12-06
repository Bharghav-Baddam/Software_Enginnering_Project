package com.buddyfinder.main.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buddyfinder.main.models.Account;
import com.buddyfinder.main.repository.AccountRepository;
import com.buddyfinder.main.repository.ActivityRepository;

@Service
public class AdminService {

	@Autowired
	AccountRepository accountRepository;
	

	public boolean blockUser(Integer id) {
		Optional<Account> x = accountRepository.findById(id);
		
		if(x.isPresent()) {
			Account account = (Account) x.get();
			account.setBlocked(!account.isBlocked());
			accountRepository.save(account);
			return true;
		}else {
			return false;
		}
	}

}
