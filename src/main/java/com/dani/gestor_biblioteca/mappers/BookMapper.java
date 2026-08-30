package com.dani.gestor_biblioteca.mappers;

import com.dani.gestor_biblioteca.dto.BookResponseDTO;
import com.dani.gestor_biblioteca.models.Book;

public class BookMapper {

    public static BookResponseDTO toDTO(Book book){

        BookResponseDTO dto = new BookResponseDTO();

        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setPrice(book.getPrice());
        dto.setNumberOfPages(book.getNumberOfPages());
        dto.setAuthorId(book.getAuthor().getId());
        dto.setAuthorName(book.getAuthor().getName());

        return dto;

    }

}
