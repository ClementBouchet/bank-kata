import fr.lacombe.Account;
import fr.lacombe.AccountHistory;
import fr.lacombe.Amount;
import fr.lacombe.HistoryLine;
import fr.lacombe.OperationType;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    public void when_a_bank_client_makes_a_deposit_in_an_empty_account_then_the_account_balance_is_the_amount_deposited() {
        Amount initialAccountBalance = Amount.of(BigDecimal.ZERO);
        Account account = new Account(initialAccountBalance, new AccountHistory(new ArrayList<>()));
        LocalDateTime operationDate = LocalDateTime.of(2019, 1, 1, 12, 0);
        Amount amountDeposited = Amount.of(BigDecimal.valueOf(10.19));

        account.deposit(amountDeposited, operationDate);

        assertThat(account.accountBalance).isEqualTo(amountDeposited);
    }

    @Test
    public void when_a_bank_client_makes_a_deposit_then_the_account_balance_is_sum_between_the_amount_deposited_and_the_former_account_balance() {
        Amount initialAccountBalance = Amount.of(BigDecimal.valueOf(10.19));
        Account account = new Account(initialAccountBalance, new AccountHistory(new ArrayList<>()));
        LocalDateTime operationDate = LocalDateTime.of(2019, 1, 1, 12, 0);
        Amount amountDeposited = Amount.of(BigDecimal.valueOf(9.94));

        account.deposit(amountDeposited, operationDate);

        Amount expectedAccountBalance = Amount.of(BigDecimal.valueOf(20.13));
        assertThat(account.accountBalance).isEqualTo(expectedAccountBalance);
    }

    @Test
    public void when_a_bank_client_makes_a_deposit_then_the_account_balance_is_substraction_between_the_amount_deposited_and_the_former_account_balance() {
        Amount initialAccountBalance = Amount.of(BigDecimal.valueOf(110.95));
        Account account = new Account(initialAccountBalance, new AccountHistory(new ArrayList<>()));
        LocalDateTime operationDate = LocalDateTime.of(2019, 1, 1, 12, 0);
        Amount amountWithdrawn = Amount.of(BigDecimal.valueOf(9.05));

        account.withdraw(amountWithdrawn, operationDate);

        Amount expectedAccountBalance = Amount.of(BigDecimal.valueOf(101.9));
        assertThat(account.accountBalance).isEqualTo(expectedAccountBalance);
    }

    @Test
    public void when_bank_client_makes_deposit_then_add_one_history_line() {
        LocalDateTime operationDate = LocalDateTime.of(2019, 1, 1, 12, 0);
        Amount operationAmount = Amount.of(BigDecimal.valueOf(12));
        Amount accountBalance = Amount.of(BigDecimal.valueOf(12));
        List<HistoryLine> historyLines = new ArrayList<>();
        historyLines.add(new HistoryLine(OperationType.DEPOSIT, operationDate, operationAmount, accountBalance));

        Account account = new Account(Amount.of(BigDecimal.ZERO), new AccountHistory(new ArrayList<>()));


        account.deposit(operationAmount, operationDate);


        AccountHistory expectedHistory = new AccountHistory(historyLines);
        assertThat(account.getAccountHistory()).isEqualTo(expectedHistory);
    }

    @Test
    public void when_bank_client_makes_withdrawal_then_add_one_history_line() {
        LocalDateTime operationDate = LocalDateTime.of(2019, 1, 1, 12, 0);
        Amount operationAmount = Amount.of(BigDecimal.valueOf(20));
        Amount accountBalance = Amount.of(BigDecimal.valueOf(-20));
        List<HistoryLine> historyLines = new ArrayList<>();
        historyLines.add(new HistoryLine(OperationType.WITHDRAWAL, operationDate, operationAmount, accountBalance));

        Account account = new Account(Amount.of(BigDecimal.ZERO), new AccountHistory(new ArrayList<>()));


        account.withdraw(operationAmount, operationDate);


        AccountHistory expectedHistory = new AccountHistory(historyLines);
        assertThat(account.getAccountHistory()).isEqualTo(expectedHistory);
    }
}
