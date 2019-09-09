package fr.lacombe;

public class WithdrawalOperation extends Operation{
    private Amount operationAmount;

    public WithdrawalOperation(Amount operationAmount) {
        this.operationAmount = operationAmount;
    }

    public void affectTo(Account account) {
        account.withdraw(operationAmount);
    }
}
