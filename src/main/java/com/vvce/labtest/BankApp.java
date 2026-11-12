package com.vvce.labtest;

import java.math.BigDecimal;

public class BankApp {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(new BigDecimal("1000.00"));
        System.out.println("Initial Balance: " + account.getBalance());

        account.deposit(new BigDecimal("500.00"));
        System.out.println("Balance after deposit: " + account.getBalance());

        account.withdraw(new BigDecimal("200.00"));
        System.out.println("Balance after withdrawal: " + account.getBalance());
    }
}