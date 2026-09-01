package com.dani.gestor_biblioteca.services;

import com.dani.gestor_biblioteca.dto.BookResponseDTO;
import com.dani.gestor_biblioteca.models.Author;
import com.dani.gestor_biblioteca.models.Book;
import com.dani.gestor_biblioteca.repositories.AuthorRepository;
import com.dani.gestor_biblioteca.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository repository;

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private BookService service;

    @Test
    void createBook_shouldReturnCreatedBook(){

        Book book = new Book(1L, "Cien años de soledad", 471, 18.5, new Author(1L, "Gabriel García Márquez", 87, "Colombiano", null));
        Mockito.when(repository.save(book)).thenReturn(book);
        Mockito.when(authorRepository.findById(1L)).thenReturn(Optional.of(book.getAuthor()));
        BookResponseDTO result = service.createBook(book);

        assertEquals("Cien años de soledad", result.getTitle());
    }

    @Test
    void searchBookById_shouldThrowException_whenNotFound(){

        Mockito.when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> service.findBookById(1L));

    }

    @Test
    void deleteBook_shouldCallRepositoryDelete(){

        Long id = 1L;

        service.deleteBook(id);

        Mockito.verify(repository).deleteById(id);
    }

}
