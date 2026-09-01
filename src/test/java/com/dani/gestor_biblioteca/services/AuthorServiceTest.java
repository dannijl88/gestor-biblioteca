package com.dani.gestor_biblioteca.services;

import com.dani.gestor_biblioteca.dto.AuthorResponseDTO;
import com.dani.gestor_biblioteca.models.Author;
import com.dani.gestor_biblioteca.repositories.AuthorRepository;
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
public class AuthorServiceTest {

    @Mock
    private AuthorRepository repository;

    @InjectMocks
    private AuthorService service;

    @Test
    void createAuthor_shouldReturnSavedAuthor(){

        // Arrange
        Author author = new Author(1L, "Gabriel García Márquez", 87, "Colombiano", null);
        Mockito.when(repository.save(author)).thenReturn(author);

        // Act
        AuthorResponseDTO result = service.createAuthor(author);

        // Assert
        assertEquals("Gabriel García Márquez", result.getName());

    }

    @Test
    void searchAuthorById_shouldThrowException_whenNotFound(){

        // Arrange
        Mockito.when(repository.findById(999L)).thenReturn(Optional.empty());

        // Act + Assert
        assertThrows(NoSuchElementException.class, () -> service.getAuthorById(999L));

    }

    @Test
    void deleteAuthor_shouldCallRepositoryDelete(){

        // Arrange
        Long id = 1L;

        // Act
        service.deleteAuthor(id);

        // Assert
        Mockito.verify(repository).deleteById(id);

    }

}
