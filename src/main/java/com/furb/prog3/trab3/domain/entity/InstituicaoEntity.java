package com.furb.prog3.trab3.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "instituicoes")
public class InstituicaoEntity extends BaseEntity {

	@Column(name = "ds_nome")
	private String nome;
	@Column(name = "ds_entidade")
	private String entidade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEntidade() {
		return entidade;
	}

	public void setEntidade(String entidade) {
		this.entidade = entidade;
	}

}
