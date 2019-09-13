import fr.lacombe.Account;
import fr.lacombe.AccountHistory;
import fr.lacombe.Amount;
import fr.lacombe.Bank;
import fr.lacombe.HistoryLine;
import fr.lacombe.OperationType;
import fr.lacombe.TimeProvider;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BankTest {

    @Test
    public void when_make_deposit_then_do_deposit() {
        List<HistoryLine> historyLines = new ArrayList<>();
        LocalDateTime operationDate = LocalDateTime.of(2019, 1, 1, 12, 0);
        Amount operationAmount = Amount.of(BigDecimal.valueOf(20));
        Amount accountBalance = Amount.of(BigDecimal.valueOf(20));

        TimeProvider mockedTimeProvider = Mockito.mock(TimeProvider.class);
        Mockito.when(mockedTimeProvider.now()).thenReturn(operationDate);

        Account account = new Account(Amount.of(BigDecimal.ZERO), new AccountHistory(new ArrayList<>()));

        historyLines.add(new HistoryLine(OperationType.DEPOSIT, operationDate, operationAmount, accountBalance));
        AccountHistory expectedHistory = new AccountHistory(historyLines);

        Bank bank = new Bank(mockedTimeProvider);


        bank.deposit(account, operationAmount);


        Assertions.assertThat(account.getAccountHistory()).isEqualTo(expectedHistory);
    }

    @Test
    public void when_withdraw_then_do_withdrawal_in_account() {
        List<HistoryLine> historyLines = new ArrayList<>();
        LocalDateTime operationDate = LocalDateTime.of(2019, 1, 1, 12, 0);
        Amount operationAmount = Amount.of(BigDecimal.valueOf(20));
        Amount accountBalance = Amount.of(BigDecimal.valueOf(0));

        TimeProvider mockedTimeProvider = Mockito.mock(TimeProvider.class);
        Mockito.when(mockedTimeProvider.now()).thenReturn(operationDate);

        Account account = new Account(Amount.of(BigDecimal.valueOf(20)), new AccountHistory(new ArrayList<>()));

        historyLines.add(new HistoryLine(OperationType.WITHDRAWAL, operationDate, operationAmount, accountBalance));
        AccountHistory expectedHistory = new AccountHistory(historyLines);

        Bank bank = new Bank(mockedTimeProvider);


        bank.withdraw(account, operationAmount);


        Assertions.assertThat(account.getAccountHistory()).isEqualTo(expectedHistory);
    }
}
