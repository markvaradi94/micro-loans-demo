package io.olidam.loans.service.service;

import io.olidam.loans.service.model.entity.LoanEntity;
import io.olidam.loans.service.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoanService {
    private final LoanRepository repository;

    public List<LoanEntity> findAll() {
        return repository.findAll();
    }

    public List<LoanEntity> getLoansForCustomer(int customerId) {
        return repository.findByCustomerIdOrderByStartDateDesc(customerId);
    }

    public Optional<LoanEntity> findByLoanNumber(long loanNumber) {
        return repository.findById(loanNumber);
    }

    public LoanEntity createLoan(LoanEntity newLoan) {
        return repository.save(newLoan);
    }

    public Optional<LoanEntity> deleteLoan(long loanNumber) {
        Optional<LoanEntity> loanToDelete = findByLoanNumber(loanNumber);
        loanToDelete.ifPresent(repository::delete);
        return loanToDelete;
    }
}
