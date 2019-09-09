package fr.lacombe;

public class Bank {

    public void handleOperation(Operation operation, Account account) {
        operation.affectTo(account);
    }
}
