package com.furb.prog3.trab3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.furb.prog3.trab3.domain.entity.BaseEntity;
import com.furb.prog3.trab3.repository.BaseRepository;

public class BaseSecureCrudController<E extends BaseEntity, R extends BaseRepository<E>> {

	protected static final String SECURE_ROUTE = "/secure";

	@Autowired
	protected R repository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<E>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<E> getById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(repository.findById(id));
	}

}
