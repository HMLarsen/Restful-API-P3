package com.furb.prog3.trab3.domain.pojo.transform;

import com.furb.prog3.trab3.domain.entity.InstituicaoEntity;
import com.furb.prog3.trab3.domain.pojo.InstituicaoPojo;

public class InstituicaoPojoTransform implements BasePojoTransform<InstituicaoPojo, InstituicaoEntity> {

	@Override
	public InstituicaoEntity transformTo(InstituicaoEntity entity, InstituicaoPojo pojo) {
		return null;
	}

	@Override
	public InstituicaoPojo transformFrom(InstituicaoPojo pojo, InstituicaoEntity entity) {
		return null;
	}

}
