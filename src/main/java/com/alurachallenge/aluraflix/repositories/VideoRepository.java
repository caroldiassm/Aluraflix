package com.alurachallenge.aluraflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.alurachallenge.aluraflix.entities.Video;

public interface VideoRepository extends JpaRepository<Video, Long>{
	
	Page<Video> findByTitulo(String titulo, Pageable pageable);
}
