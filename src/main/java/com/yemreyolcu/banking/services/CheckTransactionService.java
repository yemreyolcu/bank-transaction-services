package com.yemreyolcu.banking.services;

import com.yemreyolcu.banking.entities.CheckTransaction;
import com.yemreyolcu.banking.repositories.CheckTransactionRepository;
import com.yemreyolcu.banking.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class CheckTransactionService extends TransactionService<CheckTransaction>{
    public CheckTransactionService(CheckTransactionRepository checkTransactionRepository) {
        super(checkTransactionRepository);
    }
}
