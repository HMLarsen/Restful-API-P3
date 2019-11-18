package com.furb.prog3.trab3.domain.pojo.transform;

import com.furb.prog3.trab3.domain.entity.ObraEntity;
import com.furb.prog3.trab3.domain.pojo.ObraPojo;

public class ObraTransform implements BaseTransform<ObraPojo, ObraEntity> {

	@Override
	public ObraEntity transformToEntity(ObraPojo pojo) {
		ObraEntity entity = new ObraEntity();
		entity.setAno(pojo.getAno());
		entity.setAutor(pojo.getAutor());
		entity.setTitulo(pojo.getTitulo());
		entity.setEdicao(pojo.getEdicao());
		entity.setLocal(pojo.getLocal());
		entity.setEditora(pojo.getEditora());
		entity.setPaginas(pojo.getPaginas());
		entity.setIsbn(pojo.getIsbn());
		entity.setIssn(pojo.getIssn());
		return entity;
	}

	@Override
	public ObraEntity updateEntity(ObraPojo pojo, ObraEntity entity) {
		if (pojo.getAutor() != null) {
			entity.setAutor(pojo.getAutor());
		}
		if (pojo.getTitulo() != null) {
			entity.setTitulo(pojo.getTitulo());
		}
		if (pojo.getAno() != null) {
			entity.setAno(pojo.getAno());
		}
		if (pojo.getEdicao() != null) {
			entity.setEdicao(pojo.getEdicao());
		}
		if (pojo.getLocal() != null) {
			entity.setLocal(pojo.getLocal());
		}
		if (pojo.getEditora() != null) {
			entity.setEditora(pojo.getEditora());
		}
		if (pojo.getPaginas() != null) {
			entity.setPaginas(pojo.getPaginas());
		}
		if (pojo.getIsbn() != null) {
			entity.setIsbn(pojo.getIsbn());
		}
		if (pojo.getIssn() != null) {
			entity.setIssn(pojo.getIssn());
		}
		return entity;
	}

}
