package com.vvce.labtest;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(new BigDecimal("1000.00"));
    }

    @Test
    void testBalanceEnquiry() {
        assertEquals(new BigDecimal("1000.00"), account.getBalance());
    }

    @Test
    void testDeposit() {
        account.deposit(new BigDecimal("500.00"));
        assertEquals(new BigDecimal("1500.00"), account.getBalance());
    }

    @Test
    void testWithdrawSuccess() {
        account.withdraw(new BigDecimal("400.00"));
        assertEquals(new BigDecimal("600.00"), account.getBalance());
    }

    @Test
    void testInsufficientBalance() {
        Exception exception = assertThrows(InsufficientBalanceException.class, () -> {
            account.withdraw(new BigDecimal("1500.00"));
        });
        assertEquals("Insufficient Balance", exception.getMessage());
        assertEquals(new BigDecimal("1000.00"), account.getBalance());
    }
}