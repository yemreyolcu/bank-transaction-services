package com.yemreyolcu.banking.services;

import com.yemreyolcu.banking.entities.BillPaymentTransaction;
import com.yemreyolcu.banking.repositories.BillPaymentTransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class BillPaymentTransactionService extends TransactionService<BillPaymentTransaction> {

    public BillPaymentTransactionService(BillPaymentTransactionRepository billPaymentTransactionRepository) {
        super(billPaymentTransactionRepository);
    }

}
