package com.yemreyolcu.banking.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class BillPaymentTransaction extends Transaction {

    @Column(name = "payee")
    private String payee;

    public BillPaymentTransaction(String payee, Double amount) {
        super(amount);
        this.payee = payee;
    }

    @Override
    public String toString() {
        return "BillPaymentTransaction{" +
                "payee=" + payee +
                "} " + super.toString();
    }
}

