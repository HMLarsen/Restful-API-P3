package com.furb.prog3.trab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.furb.prog3.trab3.domain.entity.ObraEntity;
import com.furb.prog3.trab3.domain.pojo.ObraPojo;
import com.furb.prog3.trab3.domain.pojo.transform.ObraTransform;
import com.furb.prog3.trab3.repository.ObraRepository;
import com.furb.prog3.trab3.util.SuccessResponse;

import springfox.documentation.spring.web.json.Json;

@Controller
@RequestMapping(value = ObraController.ROUTE)
public class ObraController extends BaseCrudController<ObraPojo, ObraEntity, ObraRepository> {

	protected static final String ROUTE = BaseCrudController.ROUTE + "/obras";

	@Override
	public ObraEntity transformToEntity(ObraPojo pojo) {
		return new ObraTransform().transformToEntity(pojo);
	}

	@Override
	public ObraEntity updateEntity(ObraPojo pojo, ObraEntity entity) {
		return new ObraTransform().updateEntity(pojo, entity);
	}

	@Override
	public Json getSuccessMessageDeleteEntity() {
		return SuccessResponse.message("obra removida");
	}

	@Override
	public Json getSuccessMessageDeleteAllEntities() {
		return SuccessResponse.message("obra(s) removida(s)");
	}

}
