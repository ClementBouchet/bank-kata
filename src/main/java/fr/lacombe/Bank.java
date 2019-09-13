package fr.lacombe;

import java.time.LocalDateTime;

public class Bank {
    private TimeProvider timeProvider;

    public Bank(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public void deposit(Account account, Amount amountOfOperation){
        DepositOperation depositOperation = new DepositOperation(amountOfOperation);
        handleOperation(depositOperation, account);
    }

    public void withdraw(Account account, Amount amountOfOperation){
        WithdrawalOperation withdrawalOperation = new WithdrawalOperation(amountOfOperation);
        handleOperation(withdrawalOperation, account);
    }

    public void handleOperation(Operation operation, Account account) {
        LocalDateTime operationDate = timeProvider.now();
        operation.computeOperation(account, operationDate);
    }
}
