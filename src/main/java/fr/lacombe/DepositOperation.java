package fr.lacombe;

import java.time.LocalDateTime;

public class DepositOperation extends Operation{

    private Amount amount;

    public DepositOperation(Amount amount) {
        this.amount = amount;
    }

    public void computeOperation(Account account, LocalDateTime operationDate) {
        account.deposit(amount, operationDate);
    }
}
