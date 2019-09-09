import fr.lacombe.Account;
import fr.lacombe.Amount;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class BankAccountTest {

    @Test
    public void when_a_bank_client_makes_a_deposit_in_an_empty_account_then_the_account_balance_is_the_amount_deposited() {
        Amount expectedAccountBalance = Amount.of(new BigDecimal(10.19));
        Amount initialAccountBalance = Amount.of(BigDecimal.ZERO);
        Account account = new Account(initialAccountBalance);
        Amount amountDeposited = Amount.of(BigDecimal.valueOf(10.19));

        account.deposit(amountDeposited);

        assertThat(account.accountBalance).isEqualTo(expectedAccountBalance);
    }

    @Test
    public void when_a_bank_client_makes_a_deposit_then_the_account_balance_is_sum_between_the_amount_deposited_and_the_former_account_balance() {
        Amount expectedAccountBalance = Amount.of(BigDecimal.valueOf(20.13));
        Amount initialAccountBalance = Amount.of(BigDecimal.valueOf(10.19));
        Account account = new Account(initialAccountBalance);
        Amount amountDeposited = Amount.of(BigDecimal.valueOf(9.94));

        account.deposit(amountDeposited);

        Amount accountBalanceAfterDeposit = account.accountBalance;
        assertThat(accountBalanceAfterDeposit).isEqualTo(expectedAccountBalance);
    }

    @Test
    public void when_a_bank_client_makes_a_deposit_then_the_account_balance_is_substraction_between_the_amount_deposited_and_the_former_account_balance() {
        Amount expectedAccountBalance = Amount.of(BigDecimal.valueOf(101.9));
        Amount initialAccountBalance = Amount.of(BigDecimal.valueOf(110.95));
        Account account = new Account(initialAccountBalance);
        Amount amountWithdrawn = Amount.of(BigDecimal.valueOf(9.05));

        account.withdrawal(amountWithdrawn);

        Amount accountBalanceAfterWithdrawal = account.accountBalance;
        assertThat(accountBalanceAfterWithdrawal).isEqualTo(expectedAccountBalance);
    }
}
