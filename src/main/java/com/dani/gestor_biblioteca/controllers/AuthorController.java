package com.dani.gestor_biblioteca.controllers;

import com.dani.gestor_biblioteca.dto.AuthorResponseDTO;
import com.dani.gestor_biblioteca.models.Author;
import com.dani.gestor_biblioteca.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService service;

    @PostMapping
    public ResponseEntity<AuthorResponseDTO> createAuthor(@RequestBody Author author){
        AuthorResponseDTO created = service.createAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public List<AuthorResponseDTO> getAllAuthors(){
        return service.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> getAuthorById(@PathVariable Long id){
        AuthorResponseDTO author = service.getAuthorById(id);
        return ResponseEntity.ok().body(author);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id){
        service.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }

}
