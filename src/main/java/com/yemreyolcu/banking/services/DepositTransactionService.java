package com.yemreyolcu.banking.services;

import com.yemreyolcu.banking.entities.DepositTransaction;
import com.yemreyolcu.banking.repositories.DepositTransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class DepositTransactionService extends TransactionService<DepositTransaction> {

    public DepositTransactionService(DepositTransactionRepository depositTransactionRepository) {
        super(depositTransactionRepository);
    }
}

