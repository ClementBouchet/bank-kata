package fr.lacombe;

public class Account {
    public Amount accountBalance;

    public Account(Amount accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void deposit(Amount amountDeposited) {
        accountBalance = accountBalance.add(amountDeposited);
    }
}
