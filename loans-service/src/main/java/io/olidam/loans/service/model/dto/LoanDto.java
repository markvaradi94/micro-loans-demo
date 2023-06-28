package io.olidam.loans.service.model.dto;

import lombok.Builder;
import lombok.With;

import java.time.LocalDate;

@With
@Builder
public record LoanDto(
        Integer loanNumber,
        Integer customerId,
        LocalDate startDate,
        String loanType,
        Integer totalLoan,
        Integer amountPaid,
        Integer outstandingAmount,
        LocalDate createdDate
) {
}
