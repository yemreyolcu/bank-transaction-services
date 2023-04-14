package com.yemreyolcu.banking.services;

import com.yemreyolcu.banking.entities.BankAccount;
import com.yemreyolcu.banking.repositories.BankAccountRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public BankAccount createBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount getBankAccount(String accountNumber) {
        return bankAccountRepository.findByAccountNumber(accountNumber);
    }

    public Iterable<BankAccount> getBankAccounts() {
        return bankAccountRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public BankAccount updateBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    @Transactional(readOnly = true)
    public BankAccount getBankAccountByAccountNumber(String accountNumber) {
        return bankAccountRepository.findByAccountNumber(accountNumber);
    }
}
