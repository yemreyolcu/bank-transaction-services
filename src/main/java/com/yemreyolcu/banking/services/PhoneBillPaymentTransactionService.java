package com.yemreyolcu.banking.services;

import com.yemreyolcu.banking.entities.PhoneBillPaymentTransaction;
import com.yemreyolcu.banking.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class PhoneBillPaymentTransactionService extends TransactionService<PhoneBillPaymentTransaction> {
    public PhoneBillPaymentTransactionService(TransactionRepository<PhoneBillPaymentTransaction> transactionRepository) {
        super(transactionRepository);
    }
}
