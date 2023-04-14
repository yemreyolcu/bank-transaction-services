package com.yemreyolcu.banking.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class WithdrawalTransaction extends Transaction {
    public WithdrawalTransaction(Double amount) {
        super(amount);
    }
}

