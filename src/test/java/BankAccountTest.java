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

public class BankAccountTest {

    @Test
    public void when_a_bank_client_makes_a_deposit_in_an_empty_account_then_the_account_balance_is_the_amount_deposited() {
        Amount expectedAccountBalance = Amount.of(new BigDecimal(10.19));
        Amount initialAccountBalance = Amount.of(BigDecimal.ZERO);
        TimeProvider anyTimeProvider = new TimeProvider();
        Account account = new Account(initialAccountBalance, anyTimeProvider, new AccountHistory(new ArrayList<>()));
        Amount amountDeposited = Amount.of(BigDecimal.valueOf(10.19));

        account.deposit(amountDeposited);

        assertThat(account.accountBalance).isEqualTo(expectedAccountBalance);
    }

    @Test
    public void when_a_bank_client_makes_a_deposit_then_the_account_balance_is_sum_between_the_amount_deposited_and_the_former_account_balance() {
        Amount expectedAccountBalance = Amount.of(BigDecimal.valueOf(20.13));
        Amount initialAccountBalance = Amount.of(BigDecimal.valueOf(10.19));
        TimeProvider anyTimeProvider = new TimeProvider();
        Account account = new Account(initialAccountBalance, anyTimeProvider, new AccountHistory(new ArrayList<>()));
        Amount amountDeposited = Amount.of(BigDecimal.valueOf(9.94));

        account.deposit(amountDeposited);

        Amount accountBalanceAfterDeposit = account.accountBalance;
        assertThat(accountBalanceAfterDeposit).isEqualTo(expectedAccountBalance);
    }

    @Test
    public void when_a_bank_client_makes_a_deposit_then_the_account_balance_is_substraction_between_the_amount_deposited_and_the_former_account_balance() {
        Amount expectedAccountBalance = Amount.of(BigDecimal.valueOf(101.9));
        Amount initialAccountBalance = Amount.of(BigDecimal.valueOf(110.95));
        TimeProvider anyTimeProvider = new TimeProvider();
        Account account = new Account(initialAccountBalance, anyTimeProvider, new AccountHistory(new ArrayList<>()));
        Amount amountWithdrawn = Amount.of(BigDecimal.valueOf(9.05));

        account.withdrawal(amountWithdrawn);

        Amount accountBalanceAfterWithdrawal = account.accountBalance;
        assertThat(accountBalanceAfterWithdrawal).isEqualTo(expectedAccountBalance);
    }

    @Test
    public void when_bank_client_makes_deposit_then_add_one_history_line() {
        List<HistoryLine> historyLines = new ArrayList<>();
        LocalDateTime operationDate = LocalDateTime.of(2019, 1, 1, 12, 0);
        Amount operationAmount = Amount.of(BigDecimal.valueOf(12));
        Amount accountBalance = Amount.of(BigDecimal.valueOf(12));

        TimeProvider mockedTimeProvider = Mockito.mock(TimeProvider.class);
        Mockito.when(mockedTimeProvider.now()).thenReturn(operationDate);

        Account account = new Account(Amount.of(BigDecimal.ZERO), mockedTimeProvider, new AccountHistory(new ArrayList<>()));

        historyLines.add(new HistoryLine(OperationType.DEPOSIT, operationDate, operationAmount, accountBalance));
        AccountHistory expectedHistory = new AccountHistory(historyLines);


        account.deposit(operationAmount);


        assertThat(account.getAccountHistory()).isEqualTo(expectedHistory);
    }

    @Test
    public void when_bank_client_makes_withdrawal_then_add_one_history_line() {
        List<HistoryLine> historyLines = new ArrayList<>();
        LocalDateTime operationDate = LocalDateTime.of(2019, 1, 1, 12, 0);
        Amount operationAmount = Amount.of(BigDecimal.valueOf(20));
        Amount accountBalance = Amount.of(BigDecimal.valueOf(-20));

        TimeProvider mockedTimeProvider = Mockito.mock(TimeProvider.class);
        Mockito.when(mockedTimeProvider.now()).thenReturn(operationDate);

        Account account = new Account(Amount.of(BigDecimal.ZERO), mockedTimeProvider, new AccountHistory(new ArrayList<>()));

        historyLines.add(new HistoryLine(OperationType.WITHDRAWAL, operationDate, operationAmount, accountBalance));
        AccountHistory expectedHistory = new AccountHistory(historyLines);


        account.withdrawal(operationAmount);


        assertThat(account.getAccountHistory()).isEqualTo(expectedHistory);
    }
}
