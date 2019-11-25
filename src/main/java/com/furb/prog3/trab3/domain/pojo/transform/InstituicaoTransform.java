package com.furb.prog3.trab3.domain.pojo.transform;

import javax.validation.ValidationException;

import com.furb.prog3.trab3.domain.entity.InstituicaoEntity;
import com.furb.prog3.trab3.domain.pojo.InstituicaoPojo;

public class InstituicaoTransform implements BaseTransform<InstituicaoPojo, InstituicaoEntity> {

	private void validate(InstituicaoEntity entity) {
		if (entity.getNome() == null || entity.getNome().isBlank()) {
			throw new ValidationException("Nome necessita ser informado");
		}
		if (entity.getEntidade() == null || entity.getEntidade().isBlank()) {
			throw new ValidationException("Entidade necessita ser informada");
		}
	}

	@Override
	public InstituicaoEntity transformToEntity(InstituicaoPojo pojo) {
		InstituicaoEntity entity = new InstituicaoEntity();
		entity.setId(pojo.getId());
		entity.setNome(pojo.getNome());
		entity.setEntidade(pojo.getEntidade());
		validate(entity);
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
		validate(entity);
		return entity;
	}

}
