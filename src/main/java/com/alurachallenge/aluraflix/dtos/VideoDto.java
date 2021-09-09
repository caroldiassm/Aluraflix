package com.alurachallenge.aluraflix.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import com.alurachallenge.aluraflix.entities.Video;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import org.hibernate.validator.constraints.Length;

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
public class VideoDto implements Serializable{
	private static final long serialVersionUID = 1L;

    private Long id;
	
	private Long idCategoria;
	
	@NotBlank(message = "Título é obrigatório")
	@Length(min = 5, max = 50)
	private String titulo;
	
	@Length(min = 5, max = 500)
	@NotBlank(message = "Descrição é obrigatório")
	private String descricao;
	
	@NotBlank(message = "Url é obrigatório")
	private String url;
	
	public VideoDto(Video video) {
		this.id 		 = video.getId();
		this.titulo 	 = video.getTitulo();
		this.url 		 = video.getUrl();
		this.descricao   = video.getDescricao();
		//O ERRO TA AQUI:
		this.idCategoria = video.getCategoria().getIdCategoria();
	}

	public static List<VideoDto> converter(List<Video> videos) {
		return videos.stream().map(VideoDto::new).collect(Collectors.toList());
	}
}
