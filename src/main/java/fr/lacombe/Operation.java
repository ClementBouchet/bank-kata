package fr.lacombe;

import java.time.LocalDateTime;

public abstract class Operation {

    public abstract void computeOperation(Account account, LocalDateTime operationDate);
}
