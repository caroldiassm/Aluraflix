package com.alurachallenge.aluraflix.repositories;

import com.alurachallenge.aluraflix.entities.Categoria;
import com.alurachallenge.aluraflix.entities.Video;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	Page<Categoria> findByTitulo(String titulo, Pageable pageable);

	@Query("SELECT v FROM Video v JOIN v.categoria c WHERE c.id = :id")
	Page<Video> findVideosByCategoryId(@Param("id") Long id, Pageable pageable);
    //Page<Video> findVideosByCategoria(@Param("id") Long id, Pageable pageable);	

}
