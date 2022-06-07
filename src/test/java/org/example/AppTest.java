package org.example;


import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void should_make_deposit() {
        Account account = new Account(BigDecimal.ZERO);
        account.deposit(new BigDecimal(100));
        assertThat(account.getBalance()).isEqualTo(new BigDecimal(100));
    }

    @Test
    public void should_make_withdrawal() {
        Account account = new Account(new BigDecimal(100));
        account.withdrawal(new BigDecimal(20));
        assertThat(account.getBalance()).isEqualTo(new BigDecimal(80));
    }


    @Test(expected = IllegalArgumentException.class)
    public void should_throw_business_exception_when_withdrawal_exceed_ceiling() {
        Account account = new Account(BigDecimal.ZERO);
        account.withdrawal(new BigDecimal(20));
        assertThat(account.getBalance()).isEqualTo(new BigDecimal(0));
    }

    @Test
    public void should_check_last_deposit_history() {
        Account account = new Account(BigDecimal.ZERO);
        account.deposit(new BigDecimal(100));
        List<Operation> operationsHistory = account.getOperationsHistory();
        assertThat(operationsHistory).isNotNull();
        assertThat(operationsHistory).isNotEmpty();
        Operation operation = operationsHistory.get(0);
        assertThat(operation.action()).isEqualTo(Action.Deposit);
        assertThat(operation.amount()).isEqualTo(new BigDecimal(100));
        assertThat(operation.balance()).isEqualTo(new BigDecimal(100));
    }

    @Test
    public void should_check_last_withdrawal_history() {
        Account account = new Account(new BigDecimal(100));
        account.withdrawal(new BigDecimal(20));
        List<Operation> operationsHistory = account.getOperationsHistory();
        assertThat(operationsHistory).isNotNull();
        assertThat(operationsHistory).isNotEmpty();
        Operation operation = operationsHistory.get(0);
        assertThat(operation.action()).isEqualTo(Action.Withdrawal);
        assertThat(operation.amount()).isEqualTo(new BigDecimal(20));
        assertThat(operation.balance()).isEqualTo(new BigDecimal(80));
    }
}
