package com.dani.gestor_biblioteca.services;

import com.dani.gestor_biblioteca.dto.LoanResponseDTO;
import com.dani.gestor_biblioteca.models.Book;
import com.dani.gestor_biblioteca.models.Loan;
import com.dani.gestor_biblioteca.repositories.BookRepository;
import com.dani.gestor_biblioteca.repositories.LoanRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LoanServiceTest {

    @Mock
    private LoanRepository repository;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private LoanService service;

    @Test
    void createLoan_shouldReturnSavedLoan() {
        // Arrange
        Book book = new Book(1L, "Cien años de soledad", 471, 18.5, null);
        Loan loan = new Loan(1L, LocalDate.now(), LocalDate.now().plusDays(15), false, book);

        Mockito.when(repository.findByBookAndReturned(book, false)).thenReturn(List.of());
        Mockito.when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        Mockito.when(repository.save(loan)).thenReturn(loan);

        // Act
        LoanResponseDTO result = service.createLoan(loan);

        // Assert
        assertEquals("Cien años de soledad", result.getBook().getTitle());
    }

    @Test
    void getLoanById_shouldThrowException_whenNotFound() {
        // Arrange
        Mockito.when(repository.findById(999L)).thenReturn(Optional.empty());

        // Act + Assert
        assertThrows(NoSuchElementException.class, () -> service.getLoanById(999L));
    }

    @Test
    void deleteLoan_shouldCallRepositoryDelete() {
        // Arrange
        Long id = 1L;

        // Act
        service.deleteLoan(id);

        // Assert
        Mockito.verify(repository).deleteById(id);
    }

}
