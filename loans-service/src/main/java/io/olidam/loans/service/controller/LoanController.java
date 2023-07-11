package io.olidam.loans.service.controller;

import io.olidam.loans.service.config.LoansConfig;
import io.olidam.loans.service.config.Properties;
import io.olidam.loans.service.model.dto.CustomerDto;
import io.olidam.loans.service.model.dto.LoanDto;
import io.olidam.loans.service.model.mapper.LoanMapper;
import io.olidam.loans.service.service.LoanService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("loans")
@RequiredArgsConstructor
public class LoanController {
    private final LoanService service;
    private final LoanMapper mapper;
    private final LoansConfig config;

    @GetMapping
    List<LoanDto> getAll() {
        return mapper.toApi(service.findAll());
    }

    @GetMapping("{loanNumber}")
    LoanDto findByLoanNumber(@PathVariable int loanNumber) {
        return service.findByLoanNumber(loanNumber)
                .map(mapper::toApi)
                .orElseThrow(() -> new RuntimeException("Could not find loan with loanNumber %s".formatted(loanNumber)));
    }

    @PostMapping("myLoans")
    public List<LoanDto> getLoanDetails(@RequestBody CustomerDto customer) {
        return service.getLoansForCustomer(customer.customerId()).stream()
                .map(mapper::toApi)
                .toList();
    }

    @PostMapping
    LoanDto createLoan(@RequestBody LoanDto loan) {
        return mapper.toApi(service.createLoan(mapper.toDb(loan)));
    }

    @DeleteMapping("{loanNumber}")
    LoanDto deleteLoan(@PathVariable int loanNumber) {
        return service.deleteLoan(loanNumber)
                .map(mapper::toApi)
                .orElseThrow(() -> new RuntimeException("Could not find loan with loanNumber %s".formatted(loanNumber)));
    }

    @SneakyThrows
    @GetMapping("properties")
    Properties getPropertyDetails() {
        return Properties.builder()
                .msg(config.getMsg())
                .buildVersion(config.getBuildVersion())
                .mailDetails(config.getMailDetails())
                .activeBranches(config.getActiveBranches())
                .build();
    }
}
