package com.yemreyolcu.banking;

import com.yemreyolcu.banking.entities.*;
import com.yemreyolcu.banking.repositories.BankAccountRepository;
import com.yemreyolcu.banking.repositories.DepositTransactionRepository;
import com.yemreyolcu.banking.repositories.PhoneBillPaymentTransactionRepository;
import com.yemreyolcu.banking.repositories.WithdrawalTransactionRepository;
import com.yemreyolcu.banking.services.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingApplication.class, args);
    }

    @Bean
    @Transactional
    CommandLineRunner testApplication(BankAccountRepository bankAccountRepository, DepositTransactionRepository depositTransactionRepository, WithdrawalTransactionRepository withdrawalTransactionRepository,
                                      PhoneBillPaymentTransactionRepository phoneBillPaymentTransactionRepository) {

        // This operation will execute on startup and will create a bank account with 5 transactions

        return args -> {
            BankAccount bankAccount = new BankAccount("Yunus Emre", "123-456");
            bankAccountRepository.save(bankAccount);
            DepositTransaction deposit1 = new DepositTransaction(100.0);
            DepositTransaction deposit2 = new DepositTransaction(200.0);
            WithdrawalTransaction withdrawal1 = new WithdrawalTransaction(50.0);
            WithdrawalTransaction withdrawal2 = new WithdrawalTransaction(72.50);
            PhoneBillPaymentTransaction phoneBillPayment1 = new PhoneBillPaymentTransaction("Vodafone", "5556667788", 50.0);
            bankAccount.post(deposit1);
            bankAccount.post(deposit2);
            bankAccount.post(withdrawal1);
            bankAccount.post(withdrawal2);
            bankAccount.post(phoneBillPayment1);
            depositTransactionRepository.save(deposit1);
            depositTransactionRepository.save(deposit2);
            withdrawalTransactionRepository.save(withdrawal1);
            withdrawalTransactionRepository.save(withdrawal2);
            phoneBillPaymentTransactionRepository.save(phoneBillPayment1);
            bankAccountRepository.save(bankAccount);
        };
    }


}
