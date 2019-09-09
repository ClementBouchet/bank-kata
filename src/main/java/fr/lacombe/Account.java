package fr.lacombe;

import java.time.LocalDateTime;

public class Account {
    public Amount accountBalance;
    private TimeProvider timeProvider;
    private AccountHistory accountHistory;

    public Account(Amount accountBalance, TimeProvider timeProvider, AccountHistory accountHistory) {
        this.accountBalance = accountBalance;
        this.timeProvider = timeProvider;
        this.accountHistory = accountHistory;
    }

    public void deposit(Amount amountDeposited) {
        accountBalance = accountBalance.add(amountDeposited);
        createHistoryLine(amountDeposited);
    }

    private void createHistoryLine(Amount amountDeposited) {
        LocalDateTime operationDate = timeProvider.now();
        accountHistory.addLine(OperationType.DEPOSIT, operationDate, amountDeposited, accountBalance);
    }

    public void withdrawal(Amount amountWithdrawn) {
        accountBalance = accountBalance.subtract(amountWithdrawn);
    }

    public AccountHistory getAccountHistory() {
        return accountHistory;
    }
}
