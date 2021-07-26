package com.alurachallenge.aluraflix.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.alurachallenge.aluraflix.entities.Video;
import com.alurachallenge.aluraflix.repositories.VideoRepository;

@RestController
@RequestMapping(value = "/videos")
public class VideoController {
	
	@Autowired
	private VideoRepository repository;
	@GetMapping
	public ResponseEntity<List<Video>> findAll() {
	    List<Video> result = repository.findAll();
	    return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/page")
	
	public ResponseEntity<Page<Video>> findAll(Pageable pageable ) {
	    Page<Video> result = repository.findAll(pageable);
	    return ResponseEntity.ok(result);
	}
	
	
    @GetMapping("/{id}")
    public ResponseEntity<Video> getById(@PathVariable long id) {
        Optional<Video> video = repository.findById(id);
        if (video.isPresent()) {
            return new ResponseEntity<>(new Video(video.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

	@PostMapping()
	public ResponseEntity<Video> save(@RequestBody Video video, UriComponentsBuilder uriBuilder) {
		repository.save(video);
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(video.getId()).toUri();
		return ResponseEntity.created(uri).body(new Video(video));

	} 
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Video> update(@PathVariable Long id, @RequestBody Video video) {
		video.setId(id);
		repository.save(video);
        return ResponseEntity.ok(new Video(video));        
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<Video> video = repository.findById(id);
        if (video.isPresent()) {
            return new ResponseEntity<>(new Video(video.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}
	
	
	

}


