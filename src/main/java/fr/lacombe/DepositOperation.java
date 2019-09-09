package fr.lacombe;

public class DepositOperation {

    private Amount amount;

    public DepositOperation(Amount amount) {
        this.amount = amount;
    }

    public void affectTo(Account account) {
        account.deposit(amount);
    }
}
