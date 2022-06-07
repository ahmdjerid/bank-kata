package org.bank.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private BigDecimal balance;

    private List<Operation> operations;

    public Account(BigDecimal balance) {
        this.balance = balance;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
        addOperation(new Operation(LocalDateTime.now(), amount, balance, Action.Deposit));
    }

    private void addOperation(Operation operation) {
        if (operations == null)
            operations = new ArrayList<>();
        operations.add(operation);
    }

    public void withdrawal(BigDecimal amount) {
        if (amount.compareTo(balance) > 0)
            throw new IllegalArgumentException("withdrawal denied ");
        balance = balance.subtract(amount);
        addOperation(new Operation(LocalDateTime.now(), amount, balance, Action.Withdrawal));

    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Operation> getOperationsHistory() {
        return operations;
    }
}
