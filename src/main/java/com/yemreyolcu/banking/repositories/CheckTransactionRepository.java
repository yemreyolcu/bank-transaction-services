package com.yemreyolcu.banking.repositories;

import com.yemreyolcu.banking.entities.CheckTransaction;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckTransactionRepository extends TransactionRepository<CheckTransaction> {
}