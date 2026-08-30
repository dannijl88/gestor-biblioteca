package com.dani.gestor_biblioteca.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponseDTO {

    private Long id;
    private String name;
    private Integer age;
    private String nationality;

    private List<BookSummaryDTO> books;

}
