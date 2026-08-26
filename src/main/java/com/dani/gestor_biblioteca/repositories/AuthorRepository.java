package com.dani.gestor_biblioteca.repositories;

import com.dani.gestor_biblioteca.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
