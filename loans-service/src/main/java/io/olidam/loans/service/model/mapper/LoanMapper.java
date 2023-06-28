package io.olidam.loans.service.model.mapper;

import io.olidam.loans.service.model.dto.LoanDto;
import io.olidam.loans.service.model.entity.LoanEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LoanMapper {
    LoanDto toApi(LoanEntity entity);

    LoanEntity toDb(LoanDto dto);

    default List<LoanDto> toApi(List<LoanEntity> source) {
        return source.stream()
                .map(this::toApi)
                .toList();
    }

    default List<LoanEntity> toDb(List<LoanDto> source) {
        return source.stream()
                .map(this::toDb)
                .toList();
    }
}
