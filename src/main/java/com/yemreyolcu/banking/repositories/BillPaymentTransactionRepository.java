package com.yemreyolcu.banking.repositories;

import com.yemreyolcu.banking.entities.BillPaymentTransaction;
import org.springframework.stereotype.Repository;

@Repository
public interface BillPaymentTransactionRepository extends TransactionRepository<BillPaymentTransaction> {
}