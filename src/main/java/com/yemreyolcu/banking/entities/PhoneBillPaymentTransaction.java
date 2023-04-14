package com.yemreyolcu.banking.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class PhoneBillPaymentTransaction extends BillPaymentTransaction {
    private String phoneNumber;

    public PhoneBillPaymentTransaction(String payee, String phoneNumber, Double amount) {
        super(payee, amount);
        this.phoneNumber = phoneNumber;
    }

}
