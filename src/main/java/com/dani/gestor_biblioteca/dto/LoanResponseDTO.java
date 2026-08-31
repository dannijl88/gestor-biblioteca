package com.dani.gestor_biblioteca.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanResponseDTO {

    private Long id;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private boolean returned;

    private BookSummaryDTO book;

}
