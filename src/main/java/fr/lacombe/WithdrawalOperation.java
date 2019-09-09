package fr.lacombe;

public class WithdrawalOperation {
    private Amount operationAmount;

    public WithdrawalOperation(Amount operationAmount) {
        this.operationAmount = operationAmount;
    }

    public void affectTo(Account account) {
        account.withdrawal(operationAmount);
    }
}
