package com.dani.gestor_biblioteca.controllers;

import com.dani.gestor_biblioteca.dto.BookResponseDTO;
import com.dani.gestor_biblioteca.models.Book;
import com.dani.gestor_biblioteca.services.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @PostMapping
    public ResponseEntity<BookResponseDTO> createBook(@Valid @RequestBody Book book){
        BookResponseDTO created = service.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public List<BookResponseDTO> getAllBooks(){
        return service.findAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable Long id){
        BookResponseDTO book = service.findBookById(id);
        return ResponseEntity.ok().body(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        service.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

}
