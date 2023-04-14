package com.yemreyolcu.banking.entities;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class CheckTransaction extends WithdrawalTransaction {
    private String checkNumber;
    private String payee;

    public CheckTransaction(Double amount, String checkNumber, String payee) {
        super(amount);
        this.checkNumber = checkNumber;
        this.payee = payee;
    }

}
