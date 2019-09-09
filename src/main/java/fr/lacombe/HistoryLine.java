package fr.lacombe;

import java.time.LocalDateTime;
import java.util.Objects;

public class HistoryLine {

    private OperationType operation;
    private LocalDateTime date;
    private Amount amount;
    private Amount accountBalance;

    public HistoryLine(OperationType operation, LocalDateTime date, Amount amount, Amount accountBalance) {
        this.operation = operation;
        this.date = date;
        this.amount = amount;
        this.accountBalance = accountBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoryLine that = (HistoryLine) o;
        return operation == that.operation &&
                Objects.equals(date, that.date) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(accountBalance, that.accountBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, date, amount, accountBalance);
    }
}
