package com.yemreyolcu.banking.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bank_accounts")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;

    @Column(name = "account_number", nullable = false, unique = true)
    private String accountNumber;

    @Column(name = "balance", nullable = false)
    private Double balance;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_account_id", referencedColumnName = "id")
    private List<Transaction> transactions = new ArrayList<>();

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    public BankAccount(String owner, String accountNumber) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void post(Transaction transaction) {
        transaction.setBankAccount(this);
        if (transaction instanceof DepositTransaction) {
            credit(transaction.getAmount());
        } else if (transaction instanceof WithdrawalTransaction) {
            debit(transaction.getAmount());
        } else if (transaction instanceof BillPaymentTransaction) {
            debit(transaction.getAmount());
        }
        transactions.add(transaction);
        this.balance = this.getTransactions().stream()
                .mapToDouble(t -> {
                    if (t instanceof DepositTransaction) {
                        t.setTransactionType("Deposit");
                        t.setApprovalCode(UUID.randomUUID().toString());
                        return t.getAmount();
                    } else if (t instanceof WithdrawalTransaction) {
                        t.setTransactionType("Withdrawal");
                        t.setApprovalCode(UUID.randomUUID().toString());
                        return -1 * t.getAmount();
                    } else if (t instanceof BillPaymentTransaction) {
                        t.setTransactionType("BillPayment");
                        t.setApprovalCode(UUID.randomUUID().toString());
                        return -1 * t.getAmount();
                    }
                    return 0.0;
                })
                .sum();
        // save to database new balance
    }


    public void credit(Double amount) {
        balance += amount;
    }

    public void debit(Double amount) {
        if (balance < amount) {
            throw new RuntimeException("Insufficient balance");
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", transactions=" + transactions +
                ", createdAt=" + createdAt +
                '}';
    }
}
