package fr.lacombe;

import java.time.LocalDateTime;

public class WithdrawalOperation extends Operation{
    private Amount operationAmount;

    public WithdrawalOperation(Amount operationAmount) {
        this.operationAmount = operationAmount;
    }

    public void computeOperation(Account account, LocalDateTime operationDate) {
        account.withdraw(operationAmount, operationDate);
    }
}
