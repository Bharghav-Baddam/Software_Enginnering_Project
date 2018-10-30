package com.buddyfinder.main.services;

import com.buddyfinder.main.models.User;

public interface UserRegistrationService {
	public boolean isRegistered(User user);
	public String registerUser(User user);
}
