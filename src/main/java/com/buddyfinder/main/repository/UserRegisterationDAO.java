package com.buddyfinder.main.repository;

import com.buddyfinder.main.models.User;

public interface UserRegisterationDAO {
	public boolean isRegistered(User user);
	public String registerUser(User user);
}
