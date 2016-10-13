package com.kitchen.model;

import java.io.Serializable;
import java.util.Collection;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kitchen.security.user.UserAuthority;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document
@EqualsAndHashCode(of = "id")
@CompoundIndexes(@CompoundIndex(def = "{'_id': 1, 'follow': 1}", unique = true, sparse = true))
public class User implements Entity, UserDetails, Serializable {

	private static final long serialVersionUID = 8388435675718181298L;

	@Id
	private String id;

	@NotNull
	@Size(min = 1, max = 100)
	private String name;

	@Pattern(regexp = "[A-Z0-9._%+-]+@[A-Z0-9.-]+.[A-Z]{2,4}")
	@Indexed(unique = true)
	private String email;

	@NotNull
	@Size(min = 6, max = 100)
	private String password;

	private Collection<UserAuthority> authorities;

	@Override
	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	@JsonIgnore
	public Collection<UserAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isEnabled() {
		return true;
	}
}