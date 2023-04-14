package com.yemreyolcu.banking.controllers;

import com.yemreyolcu.banking.entities.BankAccount;
import com.yemreyolcu.banking.services.BankAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank-accounts")
public class BankAccountController {
    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createBankAccount(@RequestBody BankAccount bankAccount) {
        return new ResponseEntity<>(bankAccountService.createBankAccount(bankAccount), HttpStatus.CREATED);
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<?> getBankAccount(@PathVariable String accountNumber) {
        return new ResponseEntity<>(bankAccountService.getBankAccount(accountNumber), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getBankAccounts() {
        // asc according to id
        return new ResponseEntity<>(bankAccountService.getBankAccounts(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBankAccount(@RequestBody BankAccount bankAccount, @PathVariable Long id) {
        return new ResponseEntity<>(bankAccountService.updateBankAccount(bankAccount), HttpStatus.OK);
    }

}
