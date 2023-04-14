package com.yemreyolcu.banking;

import com.yemreyolcu.banking.entities.BankAccount;
import com.yemreyolcu.banking.entities.DepositTransaction;
import com.yemreyolcu.banking.entities.PhoneBillPaymentTransaction;
import com.yemreyolcu.banking.entities.WithdrawalTransaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class BankAccountTest {
    @Test
    public void testDepositAndWithdrawal() {
        BankAccount account = new BankAccount("Test", "12345");
        account.post(new DepositTransaction(1000.0));
        account.post(new WithdrawalTransaction(200.0));
        account.post(new PhoneBillPaymentTransaction("Vodafone", "5373873272", 96.50));
        Assertions.assertEquals(703.50, account.getBalance(), 0.0001);
    }
}
