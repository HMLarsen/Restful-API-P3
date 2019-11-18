package com.furb.prog3.trab3.domain.pojo.transform;

import com.furb.prog3.trab3.domain.entity.InstituicaoEntity;
import com.furb.prog3.trab3.domain.pojo.InstituicaoPojo;

public class InstituicaoTransform implements BaseTransform<InstituicaoPojo, InstituicaoEntity> {

	@Override
	public InstituicaoEntity transformToEntity(InstituicaoPojo pojo) {
		InstituicaoEntity entity = new InstituicaoEntity();
		entity.setId(pojo.getId());
		entity.setNome(pojo.getNome());
		entity.setEntidade(pojo.getEntidade());
		return entity;
	}

	@Override
	public InstituicaoEntity updateEntity(InstituicaoPojo pojo, InstituicaoEntity entity) {
		if (pojo.getNome() != null) {
			entity.setNome(pojo.getNome());
		}
		if (pojo.getEntidade() != null) {
			entity.setEntidade(pojo.getEntidade());
		}
		return entity;
	}

}
