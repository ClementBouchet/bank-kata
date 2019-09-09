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
        createDepositHistoryLine(amountDeposited);
    }

    private void createDepositHistoryLine(Amount amountDeposited) {
        LocalDateTime operationDate = timeProvider.now();
        accountHistory.addLine(OperationType.DEPOSIT, operationDate, amountDeposited, accountBalance);
    }

    public void withdrawal(Amount amountWithdrawn) {
        accountBalance = accountBalance.subtract(amountWithdrawn);
        createWithdrawalHistoryLine(amountWithdrawn);
    }

    private void createWithdrawalHistoryLine(Amount amountWithdrawn) {
        LocalDateTime operationDate = timeProvider.now();
        accountHistory.addLine(OperationType.WITHDRAWAL, operationDate, amountWithdrawn, accountBalance);
    }

    public AccountHistory getAccountHistory() {
        return accountHistory;
    }
}
