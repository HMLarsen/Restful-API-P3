package com.furb.prog3.trab3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@SuppressWarnings("rawtypes")
public class BaseSecureCrudController<R extends JpaRepository> {

	@Autowired
	protected R repository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@RequestMapping(value = "/id", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity getById(@RequestParam("id") Long id) {
		// return ResponseEntity.ok(repository.findById(id));
		return null;
	}

}
