package fr.lacombe;

import java.time.LocalDateTime;

public class Account {

    public Amount accountBalance;
    private AccountHistory accountHistory;

    public Account(Amount accountBalance, AccountHistory accountHistory) {
        this.accountBalance = accountBalance;
        this.accountHistory = accountHistory;
    }

    public void deposit(Amount amountDeposited, LocalDateTime operationDate) {
        accountBalance = accountBalance.add(amountDeposited);
        createHistoryLine(amountDeposited, OperationType.DEPOSIT, operationDate);
    }

    public void withdraw(Amount amountWithdrawn, LocalDateTime operationDate) {
        accountBalance = accountBalance.subtract(amountWithdrawn);
        createHistoryLine(amountWithdrawn, OperationType.WITHDRAWAL, operationDate);
    }

    private void createHistoryLine(Amount amountOfTransaction, OperationType operationType, LocalDateTime operationDate){
        accountHistory.addLine(operationType, operationDate, amountOfTransaction, accountBalance);
    }

    public AccountHistory getAccountHistory() {
        return accountHistory;
    }
}
