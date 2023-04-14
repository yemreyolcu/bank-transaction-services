package com.yemreyolcu.banking.services;

import com.yemreyolcu.banking.entities.WithdrawalTransaction;
import com.yemreyolcu.banking.repositories.WithdrawalTransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class WithdrawalTransactionService extends TransactionService<WithdrawalTransaction> {

    public WithdrawalTransactionService(WithdrawalTransactionRepository transactionRepository) {
        super(transactionRepository);
    }
}
