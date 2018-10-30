package com.buddyfinder.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buddyfinder.main.models.Account;
import com.buddyfinder.main.repository.AccountRepository;

@Service
public class AuthService {

	@Autowired
	AccountRepository accountRepository;

	public Account isAuthenticated(String userEmail, String password) {

		Account account = getUserByEmail(userEmail);
		Account authenticatedUser = null;
		if (account.getPassword().equals(password)) {
			authenticatedUser = account;
		}
		return authenticatedUser;
	}

	public Account getUserByEmail(String userEmail) {

		Account account = null;
		account = accountRepository.findByEmail(userEmail);
		return account;
	}
}
