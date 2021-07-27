package com.alurachallenge.aluraflix.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.alurachallenge.aluraflix.entities.Categoria;
import com.alurachallenge.aluraflix.repositories.CategoriaRepository;

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

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() {
	    List<Categoria> result = repository.findAll();
	    return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/page")
	
	public ResponseEntity<Page<Categoria>> findAll(Pageable pageable ) {
	    Page<Categoria> result = repository.findAll(pageable);
	    return ResponseEntity.ok(result);
	}
	
	
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable long id) {
        Optional<Categoria> categoria = repository.findById(id);
        if (categoria.isPresent()) {
            return new ResponseEntity<>(new Categoria(categoria.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

	@PostMapping()
	public ResponseEntity<Categoria> save(@RequestBody Categoria categoria, UriComponentsBuilder uriBuilder) {
		repository.save(categoria);
		URI uri = uriBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).body(new Categoria(categoria));

	} 
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria) {
		categoria.setId(id);
		repository.save(categoria);
        return ResponseEntity.ok(new Categoria(categoria));        
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<Categoria> categoria = repository.findById(id);
        if (categoria.isPresent()) {
            return new ResponseEntity<>(new Categoria(categoria.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}
	
	
	

}


