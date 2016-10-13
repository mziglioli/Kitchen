package com.kitchen.security.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;

import com.kitchen.model.User;
import com.kitchen.security.token.TokenHandler;
import com.kitchen.security.user.UserAuthentication;
import com.kitchen.util.StaticContent;

@Service
public class TokenAuthenticationService {

	@Autowired
	private TokenHandler tokenHandler;

	public void addAuthentication(HttpServletResponse response, UserAuthentication userAuthentication) {
		Cookie cookie = new Cookie(StaticContent.COOKIE_AUTH_NAME,
				tokenHandler.createTokenForUser(userAuthentication.getDetails()));
		cookie.setPath(StaticContent.COOKIE_PATH);
		cookie.setHttpOnly(true);
		cookie.setMaxAge(StaticContent.COOKIE_TIME);
		response.addCookie(cookie);

		Cookie cookieId = new Cookie(StaticContent.COOKIE_USER_ID, userAuthentication.getDetails().getId());
		cookieId.setPath(StaticContent.COOKIE_PATH);
		cookieId.setMaxAge(StaticContent.COOKIE_TIME);
		response.addCookie(cookieId);
	}

	public Authentication getAuthentication(HttpServletRequest request) {
		Cookie cookie = WebUtils.getCookie(request, StaticContent.COOKIE_AUTH_NAME);
		if (cookie != null) {
			String token = cookie.getValue();
			if (token != null) {
				final User user = tokenHandler.parseUserFromToken(token);
				if (user != null) {
					return new UserAuthentication(user);
				}
			}
		}
		return null;
	}
}