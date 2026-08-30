package com.dani.gestor_biblioteca.mappers;

import com.dani.gestor_biblioteca.dto.AuthorResponseDTO;
import com.dani.gestor_biblioteca.dto.BookSummaryDTO;
import com.dani.gestor_biblioteca.models.Author;

import java.util.List;

public class AuthorMapper {

    public static AuthorResponseDTO toDto(Author author){
        AuthorResponseDTO dto = new AuthorResponseDTO();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setAge(author.getAge());
        dto.setNationality(author.getNationality());
        List<BookSummaryDTO> bookDtos = author.getBooks() == null
                ? List.of()
                : author.getBooks().stream()
                .map(book -> new BookSummaryDTO(book.getId(), book.getTitle()))
                .toList();
        dto.setBooks(bookDtos);

        return dto;
    }

}
