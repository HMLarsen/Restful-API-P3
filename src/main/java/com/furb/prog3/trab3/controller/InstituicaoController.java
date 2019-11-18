package com.furb.prog3.trab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.furb.prog3.trab3.domain.entity.InstituicaoEntity;
import com.furb.prog3.trab3.domain.pojo.InstituicaoPojo;
import com.furb.prog3.trab3.domain.pojo.transform.InstituicaoTransform;
import com.furb.prog3.trab3.repository.InstituicaoRepository;
import com.furb.prog3.trab3.util.SuccessMessage;

import springfox.documentation.spring.web.json.Json;

@Controller
@RequestMapping(value = InstituicaoController.ROUTE)
public class InstituicaoController
		extends BaseCrudController<InstituicaoPojo, InstituicaoEntity, InstituicaoRepository> {

	protected static final String ROUTE = BaseCrudController.ROUTE + "/instituicao";

	@Override
	public InstituicaoEntity transformToEntity(InstituicaoPojo pojo) {
		return new InstituicaoTransform().transformToEntity(pojo);
	}

	@Override
	public InstituicaoEntity updateEntity(InstituicaoPojo pojo, InstituicaoEntity entity) {
		return new InstituicaoTransform().updateEntity(pojo, entity);
	}

	@Override
	public Json getSuccessMessageDeleteEntity() {
		return SuccessMessage.message("instituição removida");
	}

	@Override
	public Json getSuccessMessageDeleteAllEntities() {
		return SuccessMessage.message("instituição(ões) removida(s)");
	}

}
