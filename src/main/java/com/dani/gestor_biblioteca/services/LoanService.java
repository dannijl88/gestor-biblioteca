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
