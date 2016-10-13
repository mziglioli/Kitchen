package com.kitchen.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.kitchen.model.User;
import com.kitchen.repository.UserRepository;

@Service
public class UserService extends DefaultService<User, UserRepository> {

	public User getAuthenticatedUser() {
		try {
			return (User) SecurityContextHolder.getContext().getAuthentication().getDetails();
		} catch (Exception e) {
			return new User(null, "Annonimous", "", "", null);
		}
	}
}