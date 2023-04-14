package com.yemreyolcu.banking.repositories;

import com.yemreyolcu.banking.entities.DepositTransaction;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositTransactionRepository extends TransactionRepository<DepositTransaction> {
}