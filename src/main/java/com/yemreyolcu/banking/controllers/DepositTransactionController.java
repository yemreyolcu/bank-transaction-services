package com.yemreyolcu.banking.controllers;

import com.yemreyolcu.banking.entities.DepositTransaction;
import com.yemreyolcu.banking.services.DepositTransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/deposit-transactions")
public class DepositTransactionController {
    private final DepositTransactionService depositTransactionService;

    public DepositTransactionController(DepositTransactionService depositTransactionService) {
        this.depositTransactionService = depositTransactionService;
    }

    @PostMapping("/create/{accountNumber}")
    public ResponseEntity<?> createDepositTransactionAPI(@RequestBody DepositTransaction depositTransaction, @PathVariable String accountNumber) {
        return new ResponseEntity<>(depositTransactionService.transactionCreateAPI(depositTransaction, accountNumber), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<?> transactionGetAllAPI() {
        return new ResponseEntity<>(depositTransactionService.transactionGetAllAPI(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> transactionGetAPI(@PathVariable Long id) {
        return new ResponseEntity<>(depositTransactionService.transactionGetAPI(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> transactionUpdateAPI(@RequestBody DepositTransaction depositTransaction) {
        return new ResponseEntity<>(depositTransactionService.transactionUpdateAPI(depositTransaction), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> transactionDeleteAPI(@PathVariable Long id) {
        depositTransactionService.transactionDeleteAPI(id);
        return new ResponseEntity<>("Transaction deleted", HttpStatus.OK);
    }
}
