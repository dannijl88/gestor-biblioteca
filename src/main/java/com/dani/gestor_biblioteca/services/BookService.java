package com.dani.gestor_biblioteca.services;

import com.dani.gestor_biblioteca.dto.BookResponseDTO;
import com.dani.gestor_biblioteca.mappers.BookMapper;
import com.dani.gestor_biblioteca.models.Author;
import com.dani.gestor_biblioteca.models.Book;
import com.dani.gestor_biblioteca.repositories.AuthorRepository;
import com.dani.gestor_biblioteca.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;
    private final AuthorRepository authorRepository;

    public BookResponseDTO createBook(Book book){
        Author autorCompleto = authorRepository.findById(book.getAuthor().getId()).orElseThrow();
        book.setAuthor(autorCompleto);
        repository.save(book);
        return BookMapper.toDTO(book);
    }

    public List<BookResponseDTO> findAllBooks(){
        return repository.findAll().stream().map(BookMapper::toDTO).toList();
    }

    public BookResponseDTO findBookById(Long id){
        return repository.findById(id).map(BookMapper::toDTO).orElseThrow();
    }

    public void deleteBook(Long id){
        repository.deleteById(id);
    }

}
