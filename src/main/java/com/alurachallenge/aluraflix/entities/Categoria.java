package com.alurachallenge.aluraflix.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "categorias")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String titulo;
	@NotNull
	private String cor;
	
	Categoria(){
		
	}
	
    public Categoria(Categoria categoria) {
        this.titulo = categoria.getTitulo();
        this.cor = categoria.getCor();
        this.id = categoria.getId();
    }

	public Categoria(Long id, String titulo, String cor) {
		super();
		this.id = id;
		this.titulo = titulo;	
		this.cor = cor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCor() {
		return cor;
	}

	public void setDescricao(String cor) {
		this.cor = cor;
	};
	
}
