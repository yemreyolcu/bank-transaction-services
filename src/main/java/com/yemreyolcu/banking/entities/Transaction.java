package com.yemreyolcu.banking.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "transactions")
@JsonIgnoreProperties(value = {"id"})
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_account_id")
    @JsonIgnore
    private BankAccount bankAccount;

    @Column(name = "date", nullable = false)
    @CreationTimestamp
    private LocalDateTime date;

    @Column(name = "approval_code")
    private String approvalCode;

    @Column(name = "transaction_type", nullable = false)
    private String transactionType;

    public Transaction(Double amount) {
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

}
