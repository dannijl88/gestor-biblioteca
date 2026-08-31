package com.dani.gestor_biblioteca.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "loan_date")
    private LocalDate loanDate;

    @NotNull
    @Column(name = "return_date")
    private LocalDate returnDate;

    private boolean returned;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @NotNull
    private Book book;

}
