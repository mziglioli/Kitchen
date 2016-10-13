package com.kitchen.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kitchen.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByEmail(String email);
}