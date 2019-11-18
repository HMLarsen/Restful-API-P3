package com.furb.prog3.trab3.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "obras")
public class ObraEntity extends BaseEntity {

	@Column(name = "ds_autor", nullable = false)
	private String autor;
	@Column(name = "ds_titulo", nullable = false)
	private String titulo;
	@Column(name = "nr_ano", nullable = false)
	private Integer ano;
	@Column(name = "ds_edicao")
	private String edicao;
	@Column(name = "ds_local")
	private String local;
	@Column(name = "ds_editoras")
	private String editora;
	@Column(name = "nr_paginas")
	private Integer paginas;
	@Column(name = "ds_isbn")
	private String isbn;
	@Column(name = "ds_issn")
	private String issn;

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

}
