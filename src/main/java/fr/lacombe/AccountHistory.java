package fr.lacombe;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class AccountHistory {

    private List<HistoryLine> historyLines;

    public AccountHistory(List<HistoryLine> historyLines) {
        this.historyLines = historyLines;
    }

    public void addLine(OperationType operationType, LocalDateTime operationDate, Amount operationAmount, Amount accountBalance) {
        historyLines.add(new HistoryLine(operationType, operationDate, operationAmount, accountBalance));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountHistory that = (AccountHistory) o;
        return Objects.equals(historyLines, that.historyLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(historyLines);
    }
}
