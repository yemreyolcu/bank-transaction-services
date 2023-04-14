package com.yemreyolcu.banking.controllers;

import com.yemreyolcu.banking.entities.BillPaymentTransaction;
import com.yemreyolcu.banking.services.BillPaymentTransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bill-payment-transactions")
public class BillPaymentTransactionController {
    private final BillPaymentTransactionService billPaymentTransactionService;

    public BillPaymentTransactionController(BillPaymentTransactionService billPaymentTransactionService) {
        this.billPaymentTransactionService = billPaymentTransactionService;
    }

    @PostMapping("/create/{accountNumber}")
    public ResponseEntity<?> transactionCreateAPI(@RequestBody BillPaymentTransaction billPaymentTransaction, @PathVariable String accountNumber) {
        return new ResponseEntity<>(billPaymentTransactionService.transactionCreateAPI(billPaymentTransaction, accountNumber), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> transactionGetAllAPI() {
        return new ResponseEntity<>(billPaymentTransactionService.transactionGetAllAPI(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> transactionGetAPI(@PathVariable Long id) {
        return new ResponseEntity<>(billPaymentTransactionService.transactionGetAPI(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> transactionUpdateAPI(@RequestBody BillPaymentTransaction billPaymentTransaction) {
        return new ResponseEntity<>(billPaymentTransactionService.transactionUpdateAPI(billPaymentTransaction), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> transactionDeleteAPI(@PathVariable Long id) {
        billPaymentTransactionService.transactionDeleteAPI(id);
        return new ResponseEntity<>("Transaction deleted", HttpStatus.OK);
    }
}
