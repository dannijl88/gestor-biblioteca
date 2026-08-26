package com.dani.gestor_biblioteca.services;

import com.dani.gestor_biblioteca.models.Book;
import com.dani.gestor_biblioteca.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    public Book createBook(Book book){
        return repository.save(book);
    }

    public List<Book> findAllBooks(){
        return repository.findAll();
    }

    public Book findBookById(Long id){
        return repository.findById(id).orElseThrow();
    }

    public void deleteBook(Long id){
        repository.deleteById(id);
    }

}
