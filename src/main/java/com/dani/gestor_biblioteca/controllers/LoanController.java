package com.dani.gestor_biblioteca.controllers;

import com.dani.gestor_biblioteca.models.Loan;
import com.dani.gestor_biblioteca.services.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService service;

    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan){
        Loan created = service.createLoan(loan);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public List<Loan> getAllLoans(){
        return service.getAllLoans();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id){
        Loan loan = service.getLoanById(id);
        return ResponseEntity.ok().body(loan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id){
        service.deleteLoan(id);
        return ResponseEntity.noContent().build();
    }

}
