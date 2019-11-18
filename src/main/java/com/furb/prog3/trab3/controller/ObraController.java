package com.furb.prog3.trab3.controller;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.furb.prog3.trab3.domain.entity.ObraEntity;
import com.furb.prog3.trab3.domain.pojo.ObraPojo;
import com.furb.prog3.trab3.domain.pojo.transform.ObraTransform;
import com.furb.prog3.trab3.repository.ObraRepository;
import com.furb.prog3.trab3.util.ErrorResponse;
import com.furb.prog3.trab3.util.SuccessResponse;

import springfox.documentation.spring.web.json.Json;

@Controller
@RequestMapping(value = ObraController.ROUTE)
public class ObraController {

	protected static final String ROUTE = "/secure/obras";

	@Autowired
	protected ObraRepository repository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<ObraEntity>> getAll() {
		List<ObraEntity> entities = repository.findAll();
		return ResponseEntity.ok(entities);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		ObraEntity entity = repository.findById(id);
		if (entity != null) {
			return ResponseEntity.ok(entity);
		}
		return ResponseEntity.notFound().build();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> save(@RequestBody ObraPojo pojo) {
		try {
			return ResponseEntity.ok(repository.save(transformToEntity(pojo)));
		} catch (ValidationException e) {
			return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<?> update(@RequestBody ObraPojo pojo, @PathVariable("id") Long id) {
		ObraEntity entity = repository.findById(id);
		if (entity != null) {
			updateEntity(pojo, entity);
			try {
				return ResponseEntity.ok(repository.save(entity));
			} catch (ValidationException e) {
				return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
			}
		}
		return ResponseEntity.notFound().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
		ObraEntity entity = repository.findById(id);
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

	public ObraEntity transformToEntity(ObraPojo pojo) {
		return new ObraTransform().transformToEntity(pojo);
	}

	public ObraEntity updateEntity(ObraPojo pojo, ObraEntity entity) {
		return new ObraTransform().updateEntity(pojo, entity);
	}

	public Json getSuccessMessageDeleteEntity() {
		return SuccessResponse.message("obra removida");
	}

	public Json getSuccessMessageDeleteAllEntities() {
		return SuccessResponse.message("obra(s) removida(s)");
	}
}
