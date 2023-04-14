package com.yemreyolcu.banking.services;

import com.yemreyolcu.banking.entities.*;
import com.yemreyolcu.banking.repositories.BankAccountRepository;
import com.yemreyolcu.banking.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransactionService<D extends Transaction> {
    private final TransactionRepository<D> transactionRepository;
    @Autowired
    BankAccountRepository bankAccountRepository;

    public TransactionService(TransactionRepository<D> transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public D transactionCreateAPI(D transaction, String accountNumber) {
        BankAccount bankAccount = bankAccountRepository.findByAccountNumber(accountNumber);
        String uuid = java.util.UUID.randomUUID().toString();
        transaction.setApprovalCode(uuid);
        List<Transaction> transactions = bankAccount.getTransactions();
        transactions.add(transaction);
        bankAccount.setTransactions(transactions);

        Double balance = bankAccount.getBalance();
        if ((transaction instanceof WithdrawalTransaction || transaction instanceof BillPaymentTransaction) && transaction.getAmount() > balance)
            throw new RuntimeException("Balance is not enough");
        if (transaction instanceof WithdrawalTransaction) {
            balance -= transaction.getAmount();
            transaction.setTransactionType("Withdrawal");
        } else if (transaction instanceof BillPaymentTransaction) {
            balance -= transaction.getAmount();
            transaction.setTransactionType("Bill Payment");
        } else if (transaction instanceof DepositTransaction) {
            balance += transaction.getAmount();
            transaction.setTransactionType("Deposit");
        }
        bankAccount.setBalance(balance);
        return transactionRepository.save(transaction);
    }

    public Transaction transactionGetAPI(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public D transactionUpdateAPI(D transaction) {
        return transactionRepository.save(transaction);
    }

    public void transactionDeleteAPI(Long id) {
        transactionRepository.deleteById(id);
    }

    public List<D> transactionGetAllAPI() {
        return transactionRepository.findAll();
    }
}
