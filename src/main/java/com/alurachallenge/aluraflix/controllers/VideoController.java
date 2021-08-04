package com.alurachallenge.aluraflix.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.alurachallenge.aluraflix.dtos.VideoDto;
import com.alurachallenge.aluraflix.entities.Video;
import com.alurachallenge.aluraflix.repositories.VideoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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

@RestController

@RequestMapping(value = "/videos")
public class VideoController {
	
	@Autowired
	private VideoRepository repository;
	@GetMapping
	public ResponseEntity<List<VideoDto>> findAll() {
	    List<Video> videos = repository.findAll();
		List<VideoDto> result = VideoDto.converter(videos);
	    return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/page")
	public PageImpl<VideoDto> findAll(Pageable pageable ) {
			Page<Video> video = repository.findAll(pageable); 
			return new PageImpl<VideoDto>(VideoDto.converter(video.getContent()), pageable, video.getTotalElements());
		}
	
    @GetMapping("/{id}")
    public ResponseEntity<VideoDto> getById(@PathVariable long id) {
        
		Optional<Video> video = repository.findById(id);
        if (video.isPresent()) {
			//System.out.println("OBJETO DENTRO: "+ video.get().getTitulo());
			
			VideoDto videoDto = new VideoDto(video.get());
			System.out.println("OBJETO DTO: "+ videoDto.getTitulo());

            return new ResponseEntity<>(videoDto, HttpStatus.OK);
       } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	@PostMapping()
	public ResponseEntity<VideoDto> save(@RequestBody Video video, UriComponentsBuilder uriBuilder) {	
		repository.save(video);
		//VideoDto videoDto = new VideoDto(video);
		URI uri = uriBuilder.path("/videos/{id}").buildAndExpand(video.getId()).toUri();
		return ResponseEntity.created(uri).body(new VideoDto(video));

	} 
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<VideoDto> update(@PathVariable Long id, @RequestBody Video video) {
		video.setId(id);
		repository.save(video);
        return ResponseEntity.ok(new VideoDto(video));        
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<Video> video = repository.findById(id);
		if (video.isPresent()) {
			VideoDto videoDto = new VideoDto(video.orElse(null));
            return new ResponseEntity<>(videoDto, HttpStatus.OK);
       } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}
}


