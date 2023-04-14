package com.yemreyolcu.banking.repositories;

import com.yemreyolcu.banking.entities.WithdrawalTransaction;
import org.springframework.stereotype.Repository;

@Repository
public interface WithdrawalTransactionRepository extends TransactionRepository<WithdrawalTransaction> {
}