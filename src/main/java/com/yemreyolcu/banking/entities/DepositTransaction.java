package com.yemreyolcu.banking.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class DepositTransaction extends Transaction {
    public DepositTransaction(Double amount) {
        super(amount);
    }

}
