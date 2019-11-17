package com.furb.prog3.trab3.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.furb.prog3.trab3.domain.pojo.ObraPojo;
import com.furb.prog3.trab3.repository.ObraRepository;

@Entity
@Table(name = "obra")
public class ObraEntity extends BaseEntity<ObraPojo> {
	
	@Column(name = "autor")
	private String autor;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "ano")
	private Integer ano;
	
	@Column(name = "edicao")
	private String edicao;
	
	@Column(name = "local")
	private String local;
	
	@Column(name = "editora")
	private String editora;
	
	@Column(name = "paginas")
	private String paginas;
	
	@Column(name = "isbn")
	private String isbn;
	
	@Column(name = "issn")
	private String issn;
	
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
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
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
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
	public String getPaginas() {
		return paginas;
	}
	public void setPaginas(String paginas) {
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
