package com.dani.gestor_biblioteca.services;

import com.dani.gestor_biblioteca.dto.AuthorResponseDTO;
import com.dani.gestor_biblioteca.mappers.AuthorMapper;
import com.dani.gestor_biblioteca.models.Author;
import com.dani.gestor_biblioteca.models.Book;
import com.dani.gestor_biblioteca.repositories.AuthorRepository;
import com.dani.gestor_biblioteca.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository repository;

    public AuthorResponseDTO createAuthor(Author author) {
        repository.save(author);
        return AuthorMapper.toDto(author);
    }

    public List<AuthorResponseDTO> getAllAuthors(){
        return repository.findAll().stream().map(AuthorMapper::toDto).toList();
    }

    public AuthorResponseDTO getAuthorById(Long id){
        return repository.findById(id).map(AuthorMapper::toDto).orElseThrow();
    }

    public void deleteAuthor(Long id){
        repository.deleteById(id);
    }
}