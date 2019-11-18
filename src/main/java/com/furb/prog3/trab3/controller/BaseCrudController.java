package com.furb.prog3.trab3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.furb.prog3.trab3.domain.entity.BaseEntity;
import com.furb.prog3.trab3.domain.pojo.BasePojo;
import com.furb.prog3.trab3.repository.BaseRepository;

import springfox.documentation.spring.web.json.Json;

@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
public abstract class BaseCrudController<P extends BasePojo, E extends BaseEntity, R extends BaseRepository<E>> {

	protected static final String ROUTE = "/secure";

	@Autowired
	protected R repository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAll() {
		List<E> entities = repository.findAll();
		if (entities != null && !entities.isEmpty()) {
			return ResponseEntity.ok(entities);
		}
		return ResponseEntity.notFound().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		E entity = repository.findById(id);
		if (entity != null) {
			return ResponseEntity.ok(entity);
		}
		return ResponseEntity.notFound().build();
	}

	public abstract E transformToEntity(P pojo);

	public abstract E updateEntity(P pojo, E entity);

	public abstract Json getSuccessMessageDeleteEntity();

	public abstract Json getSuccessMessageDeleteAllEntities();

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<E> save(@RequestBody P pojo) {
		return ResponseEntity.ok(repository.save(transformToEntity(pojo)));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<?> update(@RequestBody P pojo, @PathVariable("id") Long id) {
		E entity = repository.findById(id);
		if (entity != null) {
			updateEntity(pojo, entity);
			return ResponseEntity.ok(repository.save(entity));
		}
		return ResponseEntity.notFound().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
		E entity = repository.findById(id);
		if (entity != null) {
			repository.delete(repository.findById(id));
			return ResponseEntity.ok(getSuccessMessageDeleteEntity());
		}
		return ResponseEntity.notFound().build();
	}

	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<?> deleteAll() {
		if (repository.count() > 0) {
			repository.deleteAll();
			return ResponseEntity.ok(getSuccessMessageDeleteAllEntities());
		}
		return ResponseEntity.notFound().build();
	}

}
