package com.dani.gestor_biblioteca.services;

import com.dani.gestor_biblioteca.models.Loan;
import com.dani.gestor_biblioteca.repositories.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository repository;

    public Loan createLoan(Loan loan){
        // Comprobar si el libro tiene algun prestamo activo antes de prestarse
        List<Loan> lista = repository.findByBookAndReturned(loan.getBook(), false);

        if (!lista.isEmpty()){
            throw new IllegalStateException("Book is already loaned");
        }

        return repository.save(loan);
    }

    public List<Loan> getAllLoans(){
        return repository.findAll();
    }

    public Loan getLoanById(Long id){
        return repository.findById(id).orElseThrow();
    }

    public void deleteLoan(Long id){
        repository.deleteById(id);
    }



}
