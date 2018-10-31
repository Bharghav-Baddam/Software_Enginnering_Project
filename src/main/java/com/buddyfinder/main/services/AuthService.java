package com.buddyfinder.main.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buddyfinder.main.models.Account;
import com.buddyfinder.main.repository.AccountRepository;

@Service
public class AuthService {

	@Autowired
	AccountRepository accountRepository;

	private static Map<String, Account> activeSessions = new HashMap<String, Account>();

	public Account isAuthenticated(String userEmail, String password, String sessionId) {

		if (isSessionAlive(sessionId)) {
			return getSession(sessionId);
		}
		Account account = getUserByEmail(userEmail);
		Account authenticatedUser = null;
		if (account.getPassword().equals(password)) {
			authenticatedUser = account;
			activeSessions.put(sessionId, account);
		}
		return authenticatedUser;
	}

	public Account getUserByEmail(String userEmail) {

		Account account = null;
		account = accountRepository.findByEmail(userEmail);
		return account;
	}

	public boolean isSessionAlive(String sessionId) {

		return activeSessions.containsKey(sessionId);
	}

	public Account getSession(String sessionId) {
		return activeSessions.get(sessionId);
	}

	public void removeSession(String id) {
		activeSessions.remove(id);
	}
}
