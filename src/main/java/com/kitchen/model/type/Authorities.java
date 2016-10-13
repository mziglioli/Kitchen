package com.kitchen.model.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Authorities {

	USER("ROLE_USER"), ADMIN("ROLE_ADMIN");

	private String role;

}