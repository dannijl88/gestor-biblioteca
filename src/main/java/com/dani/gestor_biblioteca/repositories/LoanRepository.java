package com.dani.gestor_biblioteca.repositories;

import com.dani.gestor_biblioteca.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
