package com.dani.gestor_biblioteca.repositories;

import com.dani.gestor_biblioteca.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
