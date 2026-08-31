package com.dani.gestor_biblioteca.mappers;

import com.dani.gestor_biblioteca.dto.BookSummaryDTO;
import com.dani.gestor_biblioteca.dto.LoanResponseDTO;
import com.dani.gestor_biblioteca.models.Book;
import com.dani.gestor_biblioteca.models.Loan;

public class LoanMapper {

    public static LoanResponseDTO toDTO(Loan loan){
        LoanResponseDTO dto = new LoanResponseDTO();
        dto.setId(loan.getId());
        dto.setLoanDate(loan.getLoanDate());
        dto.setReturnDate(loan.getReturnDate());
        dto.setReturned(loan.isReturned());
        BookSummaryDTO book = new BookSummaryDTO(loan.getBook().getId(), loan.getBook().getTitle());
        dto.setBook(book);
        return dto;
    }

}
