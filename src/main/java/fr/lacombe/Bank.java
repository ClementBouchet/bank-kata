package fr.lacombe;

import java.time.LocalDateTime;

public class Bank {
    private TimeProvider timeProvider;

    public Bank(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public void deposit(Account account, Amount amountOfOperation){
        LocalDateTime operationDate = timeProvider.now();
        account.deposit(amountOfOperation, operationDate);
    }

    public void withdraw(Account account, Amount amountOfOperation){
        LocalDateTime operationDate = timeProvider.now();
        account.withdraw(amountOfOperation, operationDate);
    }

}
