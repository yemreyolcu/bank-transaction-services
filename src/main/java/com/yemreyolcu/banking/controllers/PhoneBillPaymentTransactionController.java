package com.yemreyolcu.banking.controllers;

import com.yemreyolcu.banking.entities.PhoneBillPaymentTransaction;
import com.yemreyolcu.banking.repositories.PhoneBillPaymentTransactionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/phone-bill-payment-transactions")
public class PhoneBillPaymentTransactionController {
    private final PhoneBillPaymentTransactionRepository phoneBillPaymentTransactionRepository;

    public PhoneBillPaymentTransactionController(PhoneBillPaymentTransactionRepository phoneBillPaymentTransactionRepository) {
        this.phoneBillPaymentTransactionRepository = phoneBillPaymentTransactionRepository;
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllPBPTransactions() {
        return ResponseEntity.ok(phoneBillPaymentTransactionRepository.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPBPTransaction(@RequestBody PhoneBillPaymentTransaction body) {
        return ResponseEntity.ok(phoneBillPaymentTransactionRepository.save(body));
    }
}
