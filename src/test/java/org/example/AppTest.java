package org.example;


import org.junit.Test;

import java.math.BigDecimal;

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
}
