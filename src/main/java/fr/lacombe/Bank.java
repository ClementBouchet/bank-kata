package fr.lacombe;

import java.time.LocalDateTime;

public class Bank {
    private TimeProvider timeProvider;

    public Bank(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public void handleOperation(Operation operation, Account account) {
        LocalDateTime operationDate = timeProvider.now();
        operation.computeOperation(account, operationDate);
    }
}
