package com.alurachallenge.aluraflix.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "categorias")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;
	
	@NotNull
	private String titulo;
	@NotNull
	private String cor;
	
	@OneToMany(mappedBy="categoria", cascade = CascadeType.MERGE)
    private Set<Video> videos;
	
	Categoria(){
		
	}
	
    public Categoria(Categoria categoria) {
        this.titulo = categoria.getTitulo();
        this.cor = categoria.getCor();
        this.idCategoria = categoria.getIdCategoria();
    }

	public Categoria(Long idCategoria, String titulo, String cor) {
		super();
		this.idCategoria = idCategoria;
		this.titulo = titulo;	
		this.cor = cor;
	}
	
}
