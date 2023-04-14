package com.yemreyolcu.banking.controllers;

import com.yemreyolcu.banking.entities.CheckTransaction;
import com.yemreyolcu.banking.services.CheckTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/check-transaction")
public class CheckTransactionController {
    private final CheckTransactionService checkTransactionService;

    public CheckTransactionController(CheckTransactionService checkTransactionService) {
        this.checkTransactionService = checkTransactionService;
    }

    @GetMapping("/list")
    public ResponseEntity<?> getCheckTransactions() {
        return ResponseEntity.ok(checkTransactionService.transactionGetAllAPI());
    }

    @PostMapping("/create/{accountNumber}")
    public ResponseEntity<?> createCheckTransaction(@RequestBody CheckTransaction checkTransaction, @PathVariable String accountNumber) {
        return ResponseEntity.ok(checkTransactionService.transactionCreateAPI(checkTransaction, accountNumber));
    }
}
