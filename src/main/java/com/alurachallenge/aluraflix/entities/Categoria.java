package com.alurachallenge.aluraflix.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data

@Entity
@Builder
@Getter @Setter
@NoArgsConstructor
@Table(name = "categorias")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCategoria")
	private Long idCategoria;
	
	@NotNull
	private String titulo;
	@NotNull
	private String cor;
	
	//@OneToMany(mappedBy="categoria", cascade = CascadeType.MERGE)
    //private Set<Video> videos;
	
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
