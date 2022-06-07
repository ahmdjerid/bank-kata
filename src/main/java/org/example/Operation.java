package org.example;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Operation(LocalDateTime date, BigDecimal amount, BigDecimal balance,
                        Action action) {
    @Override
    public LocalDateTime date() {
        return date;
    }

    @Override
    public BigDecimal amount() {
        return amount;
    }

    @Override
    public BigDecimal balance() {
        return balance;
    }

    @Override
    public Action action() {
        return action;
    }
}
