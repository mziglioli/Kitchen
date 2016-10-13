package com.kitchen.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kitchen.model.User;
import com.kitchen.repository.UserRepository;
import com.kitchen.util.StaticContent;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	private final AccountStatusUserDetailsChecker detailsChecker;

	public UserDetailsService() {
		this.detailsChecker = new AccountStatusUserDetailsChecker();
	}

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException(StaticContent.EXCEPTION_USER_NOT_FOUND);
		}
		detailsChecker.check(user);
		return user;
	}
}