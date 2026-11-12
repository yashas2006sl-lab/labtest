
package com.vvce.labtest;

import java.math.BigDecimal;

class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class BankAccount {

    private BigDecimal balance;

    public BankAccount(BigDecimal balance) {
        this.balance = balance;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
        System.out.println("Deposit Successful");
    }

    public void withdraw(BigDecimal amount) {

        if (amount.compareTo(balance) > 0) {
            throw new InsufficientBalanceException("Insufficient Balance");
        }

        balance = balance.subtract(amount);
        System.out.println("Withdrawal Successful");
    }

    public BigDecimal getBalance() {
        return balance;
    }
}

