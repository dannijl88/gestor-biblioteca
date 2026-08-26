package com.dani.gestor_biblioteca.services;

import com.dani.gestor_biblioteca.models.Author;
import com.dani.gestor_biblioteca.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository repository;

    public Author createAuthor(Author author) {
        return repository.save(author);
    }

    public List<Author> getAllAuthors(){
        return repository.findAll();
    }

    public Author getAuthorById(Long id){
        return repository.findById(id).orElseThrow();
    }

    public void deleteAuthor(Long id){
        repository.deleteById(id);
    }
}