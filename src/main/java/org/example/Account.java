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

    public void withdrawal(BigDecimal amount) {
        if (amount.compareTo(balance) > 0)
            throw new IllegalArgumentException("withdrawal denied ");
        balance = balance.subtract(amount);
    }

    public BigDecimal getBalance() {
        return balance;
    }

}
