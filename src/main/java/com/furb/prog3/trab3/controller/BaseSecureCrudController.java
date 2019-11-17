package com.furb.prog3.trab3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.furb.prog3.trab3.domain.entity.BaseEntity;
import com.furb.prog3.trab3.domain.pojo.BasePojo;
import com.furb.prog3.trab3.domain.pojo.transform.BasePojoTransform;
import com.furb.prog3.trab3.repository.BaseRepository;

public class BaseSecureCrudController<E extends BaseEntity, P extends BasePojo, T extends BasePojoTransform<P, E>, R extends BaseRepository<E>> {

	protected static final String SECURE_ROUTE = "/secure";

	@Autowired
	protected R repository;
	
	@Autowired
	protected T basePojoTransform;

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
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<E> save(@RequestBody P pojo) {
		return ResponseEntity.ok(repository.save(basePojoTransform.transformTo(pojo)));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<E> save(@RequestBody P pojo, @PathVariable("id") Long id) {
		return ResponseEntity.ok(repository.save(basePojoTransform.transformTo(pojo, repository.findById(id))));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
		repository.delete(repository.findById(id));
		return ResponseEntity.ok(messageSuccess("obra removida"));
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> deleteAll() {
		repository.deleteAll();
		return ResponseEntity.ok(messageSuccess("obra(s) removida(s)"));
	}
	
	private String messageSuccess(String message) {
		
		return "{\"success\":{\"text\":\"" + message + "\"}}\r\n";
	}
}
