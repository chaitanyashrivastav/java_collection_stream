package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount account ;

    @BeforeEach
    void setup(){
        account = new BankAccount(100) ;
    }
    @Test
    void testForDeposit() {
        account.deposit(900.0);
        assertEquals(1000 , account.getBalance());
    }

    @Test
    void testForWithdraw() {
        account.withdraw(50) ;
        assertEquals(50 , account.getBalance());
    }

    @Test
    void withdrawalFailDueTOInsufficientFunds(){
        assertFalse(account.withdraw(900.0),"insufficient funds in the account");
    }

    @Test
    void testWithdrawFailDueToNegativeAmount() {
        assertFalse(account.withdraw(-199), "negative amount can't be withdrawn");
    }
}