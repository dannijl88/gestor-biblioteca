package com.dani.gestor_biblioteca.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDTO {

    private Long id;
    private String title;
    private Integer numberOfPages;
    private Double price;

    private Long authorId;
    private String authorName;

}
