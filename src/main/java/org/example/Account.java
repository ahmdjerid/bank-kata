package org.example;

import java.math.BigDecimal;

public class Account {

    private BigDecimal balance;

    public Account(BigDecimal balance) {
        this.balance = balance;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
