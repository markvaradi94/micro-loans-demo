package io.olidam.loans.service.model.dto;

import lombok.Builder;
import lombok.With;

import java.time.LocalDate;

@With
@Builder
public record CustomerDto(
        Integer customerId,
        String name,
        String mobileNumber,
        String email,
        LocalDate createdDate
) {
}
