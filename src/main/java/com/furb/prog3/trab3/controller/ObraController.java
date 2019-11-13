package com.furb.prog3.trab3.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.furb.prog3.trab3.domain.entity.ObraEntity;
import com.furb.prog3.trab3.repository.ObraRepository;

@Controller
@RequestMapping(value = ObraController.ROUTE, produces = { MediaType.APPLICATION_JSON_VALUE })
public class ObraController extends BaseSecureCrudController<ObraEntity, ObraRepository> {

	protected static final String ROUTE = BaseSecureCrudController.SECURE_ROUTE + "/obras";

}
