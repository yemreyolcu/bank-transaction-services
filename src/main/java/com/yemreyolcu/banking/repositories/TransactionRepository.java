package com.yemreyolcu.banking.repositories;

import com.yemreyolcu.banking.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository<D extends Transaction> extends JpaRepository<D, Long> {
}

