package com.yemreyolcu.banking.repositories;

import com.yemreyolcu.banking.entities.PhoneBillPaymentTransaction;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneBillPaymentTransactionRepository extends TransactionRepository<PhoneBillPaymentTransaction> {
}