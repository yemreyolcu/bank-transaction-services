package com.yemreyolcu.banking.controllers;

import com.yemreyolcu.banking.entities.Transaction;
import com.yemreyolcu.banking.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService<Transaction> transactionService;

    public TransactionController(TransactionService<Transaction> transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/create/{accountNumber}")
    public ResponseEntity<?> transactionCreateAPI(@RequestBody Transaction transaction, @PathVariable String accountNumber) {
        try {
            Transaction createdTransaction = transactionService.transactionCreateAPI(transaction, accountNumber);
            return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> transactionGetAllAPI() {
        Iterable<Transaction> transactions = transactionService.transactionGetAllAPI();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> transactionGetAPI(@PathVariable Long id) {
        Optional<Transaction> transactionOptional = Optional.ofNullable(transactionService.transactionGetAPI(id));
        if (transactionOptional.isPresent())
            return new ResponseEntity<>(transactionOptional.get(), HttpStatus.OK);
        return new ResponseEntity<>("Transaction not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> transactionUpdateAPI(@RequestBody Transaction transaction) {
        Optional<Transaction> transactionOptional = Optional.ofNullable(transactionService.transactionUpdateAPI(transaction));
        if (transactionOptional.isPresent())
            return new ResponseEntity<>(transactionOptional.get(), HttpStatus.OK);
        return new ResponseEntity<>("Transaction not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> transactionDeleteAPI(@PathVariable Long id) {
        transactionService.transactionDeleteAPI(id);
        return new ResponseEntity<>("Transaction deleted", HttpStatus.OK);
    }
}
