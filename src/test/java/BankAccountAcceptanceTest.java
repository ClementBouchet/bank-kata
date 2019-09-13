import fr.lacombe.Account;
import fr.lacombe.AccountHistory;
import fr.lacombe.Amount;
import fr.lacombe.HistoryLine;
import fr.lacombe.OperationType;
import fr.lacombe.TimeProvider;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BankAccountAcceptanceTest {

    @Test
    public void account_statement_acceptance_test() {

        OperationType operation1 = OperationType.DEPOSIT;
        LocalDateTime date1 = LocalDateTime.of(2019, 1,1,12,0);
        Amount amount1 = Amount.of(BigDecimal.valueOf(10));
        Amount accountBalance1 = Amount.of(BigDecimal.valueOf(150));

        OperationType operation2 = OperationType.WITHDRAWAL;
        LocalDateTime date2 = LocalDateTime.of(2019, 1,2,14,0);
        Amount amount2 = Amount.of(BigDecimal.valueOf(50));
        Amount accountBalance2 = Amount.of(BigDecimal.valueOf(100));

        TimeProvider mockedTimeProvider = Mockito.mock(TimeProvider.class);
        Mockito.when(mockedTimeProvider.now()).thenReturn(date1,date2);

        List<HistoryLine> historyLines = new ArrayList<>();
        historyLines.add(new HistoryLine(operation1, date1, amount1, accountBalance1));
        historyLines.add(new HistoryLine(operation2, date2, amount2, accountBalance2));
        AccountHistory expectedAccountStatement = new AccountHistory(historyLines);

        Account account = new Account(Amount.of(BigDecimal.valueOf(140)), new AccountHistory(new ArrayList<>()));


        account.deposit(amount1, date1);
        account.withdraw(amount2, date2);


        assertThat(account.getAccountHistory()).isEqualTo(expectedAccountStatement);
    }
}
