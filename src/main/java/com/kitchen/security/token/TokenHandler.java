package com.kitchen.security.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kitchen.model.User;
import com.kitchen.security.service.UserDetailsService;
import com.kitchen.util.StaticContent;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenHandler {

	@Autowired
	private UserDetailsService userDetailsService;

	public User parseUserFromToken(String token) {
		String username = Jwts.parser().setSigningKey(StaticContent.JWTS_SECRET).parseClaimsJws(token).getBody()
				.getSubject();
		return userDetailsService.loadUserByUsername(username);
	}

	public String createTokenForUser(User user) {
		return Jwts.builder().setSubject(user.getUsername())
				.signWith(SignatureAlgorithm.HS512, StaticContent.JWTS_SECRET).compact();
	}
}
