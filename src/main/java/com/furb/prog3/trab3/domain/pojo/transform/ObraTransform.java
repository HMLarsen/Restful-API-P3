package com.furb.prog3.trab3.domain.pojo.transform;

import org.springframework.stereotype.Component;

import com.furb.prog3.trab3.domain.entity.ObraEntity;
import com.furb.prog3.trab3.domain.pojo.ObraPojo;

@Component
public class ObraTransform implements ObraPojoTransform {

	@Override
	public ObraEntity transformTo(ObraPojo pojo) {
		ObraEntity entity = new ObraEntity();
			
		return transformTo(pojo, entity);
	}
	
	@Override
	public ObraEntity transformTo(ObraPojo pojo, ObraEntity entity) {
		
		if (pojo.getAno() instanceof Integer)
			entity.setAno(pojo.getAno());
		
		if (pojo.getAutor() instanceof String)
			entity.setAutor(pojo.getAutor());
		
		if (pojo.getTitulo() instanceof String)
			entity.setTitulo(pojo.getTitulo());
		
		if (pojo.getEdicao() instanceof String)
			entity.setEdicao(pojo.getEdicao());
		
		if (pojo.getLocal() instanceof String)
			entity.setLocal(pojo.getLocal());
		
		if (pojo.getEditora() instanceof String)
			entity.setEditora(pojo.getEditora());
		
		if (pojo.getPaginas() instanceof String)
			entity.setPaginas(pojo.getPaginas());
		
		if (pojo.getIsbn() instanceof String)
			entity.setIsbn(pojo.getIsbn());
		
		if (pojo.getIssn() instanceof String)
			entity.setIssn(pojo.getIssn());
		
		return entity;
	}
}
