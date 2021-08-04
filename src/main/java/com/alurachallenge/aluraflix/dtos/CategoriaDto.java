package com.alurachallenge.aluraflix.dtos;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import com.alurachallenge.aluraflix.entities.Categoria;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoriaDto {

    private Long idCategoria;
	
	@NotBlank(message = "Título é obrigatório")
	private String titulo;
	
    @NotBlank(message = "Cor é obrigatório")
	private String cor;

    public CategoriaDto(Categoria categoria) {
		this.idCategoria  = categoria.getIdCategoria();
		this.titulo = categoria.getTitulo();
		this.cor = categoria.getCor();
	}

	public static List<CategoriaDto> converter(List<Categoria> categorias) {
		return categorias.stream().map(CategoriaDto::new).collect(Collectors.toList());
	}
}
