package io.olidam.loans.service.repository;

import io.olidam.loans.service.model.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<LoanEntity, Long> {
    List<LoanEntity> findByCustomerIdOrderByStartDateDesc(int customerId);
}
