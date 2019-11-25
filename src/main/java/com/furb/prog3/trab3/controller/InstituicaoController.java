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

import com.furb.prog3.trab3.domain.entity.InstituicaoEntity;
import com.furb.prog3.trab3.domain.pojo.InstituicaoPojo;
import com.furb.prog3.trab3.domain.pojo.transform.InstituicaoTransform;
import com.furb.prog3.trab3.repository.InstituicaoRepository;
import com.furb.prog3.trab3.util.ErrorResponse;
import com.furb.prog3.trab3.util.SuccessResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.spring.web.json.Json;

@Api(value = "API Rest Instituição")
@ApiResponses(value = { @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
		@ApiResponse(code = 403, message = "O serviço está indisponível no momento tente novamente mais tarde"),
		@ApiResponse(code = 404, message = "Serviço não encontrado"),
		@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
@Controller
@RequestMapping(value = InstituicaoController.ROUTE)
public class InstituicaoController {

	protected static final String ROUTE = "/secure/instituicao";

	@Autowired
	protected InstituicaoRepository repository;

	@ApiOperation(value = "Retorna todas as instituições")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todas as instituições") })
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<InstituicaoEntity>> getAll() {
		List<InstituicaoEntity> entities = repository.findAll();
		return ResponseEntity.ok(entities);
	}

	@ApiOperation(value = "Retorna uma instituição")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna uma instituição") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		InstituicaoEntity entity = repository.findById(id);
		if (entity != null) {
			return ResponseEntity.ok(entity);
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Insere uma instituição")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Instituição inserida com sucesso"),
			@ApiResponse(code = 201, message = "Instituição inserida") })
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> save(@RequestBody InstituicaoPojo pojo) {
		try {
			return ResponseEntity.ok(repository.save(transformToEntity(pojo)));
		} catch (ValidationException e) {
			return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
		}
	}

	@ApiOperation(value = "Altera uma instituição")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Instituição alterada com sucesso"),
			@ApiResponse(code = 201, message = "Instituição alterada") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<?> update(@RequestBody InstituicaoPojo pojo, @PathVariable("id") Long id) {
		InstituicaoEntity entity = repository.findById(id);
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

	@ApiOperation(value = "Deleta uma instituição")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Instituição deletada com sucesso"),
			@ApiResponse(code = 201, message = "Instituição não encontrada") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
		InstituicaoEntity entity = repository.findById(id);
		if (entity != null) {
			repository.delete(repository.findById(id));
			return ResponseEntity.ok(getSuccessMessageDeleteEntity());
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Deleta todas as instituições")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Instituições deletadas com sucesso"),
			@ApiResponse(code = 201, message = "Nenhuma instituição foi encontrada") })
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<?> deleteAll() {
		if (repository.count() > 0) {
			repository.deleteAll();
			return ResponseEntity.ok(getSuccessMessageDeleteAllEntities());
		}
		return ResponseEntity.notFound().build();
	}

	public InstituicaoEntity transformToEntity(InstituicaoPojo pojo) {
		return new InstituicaoTransform().transformToEntity(pojo);
	}

	public InstituicaoEntity updateEntity(InstituicaoPojo pojo, InstituicaoEntity entity) {
		return new InstituicaoTransform().updateEntity(pojo, entity);
	}

	public Json getSuccessMessageDeleteEntity() {
		return SuccessResponse.message("instituição removida");
	}

	public Json getSuccessMessageDeleteAllEntities() {
		return SuccessResponse.message("instituição(ões) removida(s)");
	}

}
