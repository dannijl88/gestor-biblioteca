package com.dani.gestor_biblioteca.services;

import com.dani.gestor_biblioteca.dto.LoanResponseDTO;
import com.dani.gestor_biblioteca.mappers.LoanMapper;
import com.dani.gestor_biblioteca.models.Book;
import com.dani.gestor_biblioteca.models.Loan;
import com.dani.gestor_biblioteca.repositories.BookRepository;
import com.dani.gestor_biblioteca.repositories.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository repository;
    private final BookRepository bookRepository;

    public LoanResponseDTO createLoan(Loan loan){
        // Comprobar si el libro tiene algun prestamo activo antes de prestarse
        List<Loan> lista = repository.findByBookAndReturned(loan.getBook(), false);

        if (!lista.isEmpty()){
            throw new IllegalStateException("Book is already loaned");
        }

        Book completeBook = bookRepository.findById(loan.getBook().getId()).orElseThrow();
        loan.setBook(completeBook);

        repository.save(loan);
        return LoanMapper.toDTO(loan);
    }

    public List<LoanResponseDTO> getAllLoans(){
        return repository.findAll().stream().map(LoanMapper::toDTO).toList();
    }

    public LoanResponseDTO getLoanById(Long id){
        return repository.findById(id).map(LoanMapper::toDTO).orElseThrow();
    }

    public void deleteLoan(Long id){
        repository.deleteById(id);
    }



}
