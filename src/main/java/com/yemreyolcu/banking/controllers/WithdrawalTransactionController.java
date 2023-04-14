package com.yemreyolcu.banking.controllers;

import com.yemreyolcu.banking.entities.WithdrawalTransaction;
import com.yemreyolcu.banking.services.WithdrawalTransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/withdrawal-transaction")
public class WithdrawalTransactionController {
    private final WithdrawalTransactionService withdrawalTransactionService;

    public WithdrawalTransactionController(WithdrawalTransactionService withdrawalTransactionService) {
        this.withdrawalTransactionService = withdrawalTransactionService;
    }

    @PostMapping("/create/{accountNumber}")
    public ResponseEntity<?> createWithdrawalTransactionAPI(@RequestBody WithdrawalTransaction withdrawalTransaction, @PathVariable String accountNumber) {
        return new ResponseEntity<>(withdrawalTransactionService.transactionCreateAPI(withdrawalTransaction, accountNumber), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> transactionGetAllAPI() {
        return new ResponseEntity<>(withdrawalTransactionService.transactionGetAllAPI(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> transactionGetAPI(@PathVariable Long id) {
        return new ResponseEntity<>(withdrawalTransactionService.transactionGetAPI(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> transactionUpdateAPI(@RequestBody WithdrawalTransaction withdrawalTransaction) {
        return new ResponseEntity<>(withdrawalTransactionService.transactionUpdateAPI(withdrawalTransaction), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> transactionDeleteAPI(@PathVariable Long id) {
        withdrawalTransactionService.transactionDeleteAPI(id);
        return new ResponseEntity<>("Transaction deleted", HttpStatus.OK);
    }
}
