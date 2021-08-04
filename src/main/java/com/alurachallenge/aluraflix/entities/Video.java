package com.alurachallenge.aluraflix.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "videos")
@Getter @Setter
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "idCategoria" , insertable = true, updatable = true)
	private Categoria categoria;
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
		this.categoria = video.getCategoria();
    }

	public Video(Long id, String titulo, String descricao,String url, Categoria categoria) {
		super();
		this.id = id;
		this.titulo = titulo;	
		this.descricao = descricao;
		this.url = url;
		this.categoria = categoria;
	}
	
}
