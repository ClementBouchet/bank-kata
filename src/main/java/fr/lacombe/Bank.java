package fr.lacombe;

public class Bank {
    public void handleOperation(DepositOperation operation, Account account) {
        operation.affectTo(account);
    }
}
