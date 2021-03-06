package com.alurachallenge.aluraflix.repositories;

import com.alurachallenge.aluraflix.entities.Video;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long>{
	
	Page<Video> findByTitulo(String titulo, Pageable pageable);
}
