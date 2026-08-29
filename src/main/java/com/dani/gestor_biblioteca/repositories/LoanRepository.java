package com.dani.gestor_biblioteca.repositories;

import com.dani.gestor_biblioteca.models.Book;
import com.dani.gestor_biblioteca.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByBookAndReturned(Book book, boolean returned);

}
