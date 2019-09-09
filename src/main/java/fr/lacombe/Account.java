package fr.lacombe;

import java.math.BigDecimal;

public class Account {
    public BigDecimal accountBalance;

    public Account(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void deposit(BigDecimal amountDeposited) {
        accountBalance = amountDeposited;
    }
}
