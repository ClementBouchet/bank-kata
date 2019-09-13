package fr.lacombe;

import java.time.LocalDateTime;
import java.util.Objects;

public class HistoryLine {

    private OperationType operationType;
    private LocalDateTime date;
    private Amount amountOfTransaction;
    private Amount accountBalance;

    public HistoryLine(OperationType operationType, LocalDateTime date, Amount amountOfTransaction, Amount accountBalance) {
        this.operationType = operationType;
        this.date = date;
        this.amountOfTransaction = amountOfTransaction;
        this.accountBalance = accountBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoryLine that = (HistoryLine) o;
        return operationType == that.operationType &&
                Objects.equals(date, that.date) &&
                Objects.equals(amountOfTransaction, that.amountOfTransaction) &&
                Objects.equals(accountBalance, that.accountBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationType, date, amountOfTransaction, accountBalance);
    }
}
