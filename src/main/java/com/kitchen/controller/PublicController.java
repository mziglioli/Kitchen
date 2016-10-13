package com.kitchen.controller;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kitchen.model.User;
import com.kitchen.model.type.Authorities;
import com.kitchen.security.user.UserAuthority;
import com.kitchen.service.UserService;
import com.kitchen.util.URL;

@RestController
@RequestMapping(value = URL.URL_PUBLIC, produces = MediaType.APPLICATION_JSON_VALUE)
public class PublicController extends DefaultController<User, UserService> {

	@Autowired
	private UserService userService;

	@PostMapping(value = URL.URL_LOGIN)
	public void signUp(@RequestBody User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		userService.save(user);
	}

	@GetMapping(value = "test")
	public Collection<User> test() {
		// build();
		return userService.findAll();
	}

	public void build() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Collection<UserAuthority> authorities = new HashSet<>();
		authorities.add(new UserAuthority(Authorities.USER.getRole()));
		authorities.add(new UserAuthority(Authorities.ADMIN.getRole()));

		User user = new User();
		user.setName("marcelo");
		user.setEmail("marceloziglioli@gmail.com");
		user.setPassword(encoder.encode("teste"));
		user.setAuthorities(authorities);

		User user2 = new User();
		user2.setName("mallmann");
		user2.setEmail("a.a.mallmann@gmail.com");
		user2.setPassword(encoder.encode("teste"));
		user2.setAuthorities(authorities);

		userService.getRepository().deleteAll();
		userService.save(user);
		userService.save(user2);
	}
}