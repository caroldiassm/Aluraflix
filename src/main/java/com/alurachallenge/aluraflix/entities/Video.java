package com.alurachallenge.aluraflix.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "videos")
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String titulo;
	@NotNull
	private String descricao;
	@NotNull
	private String url;
	
	Video(){
		
	}
	
    public Video(Video video) {
        this.titulo = video.getTitulo();
        this.descricao = video.getDescricao();
        this.url = video.getUrl();
        this.id = video.getId();
    }

	public Video(Long id, String titulo, String descricao,String url) {
		super();
		this.id = id;
		this.titulo = titulo;	
		this.descricao = descricao;
		this.url = url;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	};
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	};
	
	
}
