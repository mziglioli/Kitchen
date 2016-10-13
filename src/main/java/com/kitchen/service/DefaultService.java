package com.kitchen.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.kitchen.model.Entity;
import com.kitchen.util.StaticContent;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

@SuppressWarnings({ "rawtypes", "unchecked" })
@Log4j
@Getter
public abstract class DefaultService<T extends Entity, R extends MongoRepository> {

	@Autowired
	protected R repository;

	@Autowired
	protected MongoTemplate mongoTemplate;

	@Autowired
	protected UserService userService;

	public final T save(T entity) {
		if (entity.getId() != null) {
			return update(entity);
		}
		log("save " + entity.getClass().getName());
		beforeInsert();
		repository.save(entity);
		afterInsert();
		return entity;
	}

	private T update(T entity) {
		log("update " + entity.getClass().getName());
		beforeUpdate();
		repository.save(entity);
		afterUpdate();
		return entity;
	}

	public final void delete(T entity) {
		log("delete " + entity.getClass().getName());
		beforeDelete();
		repository.delete(entity);
		afterDelete();
	}

	public Collection<T> findAll() {
		return repository.findAll();
	}

	protected void afterInsert() {

	}

	protected void afterUpdate() {

	}

	protected void afterDelete() {

	}

	protected void beforeInsert() {

	}

	protected void beforeUpdate() {

	}

	protected void beforeDelete() {

	}

	protected void log(String msg) {
		log.info(msg + StaticContent.LOG_SEPARATOR + userService.getAuthenticatedUser().toString());
	}
}
