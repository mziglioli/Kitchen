package com.kitchen.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.kitchen.model.Entity;
import com.kitchen.service.DefaultService;

import lombok.Getter;

public abstract class DefaultController<E extends Entity, T extends DefaultService<?, ?>> {

	@Autowired
	@Getter
	protected T service;

}