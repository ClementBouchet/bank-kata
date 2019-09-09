import fr.lacombe.Account;
import fr.lacombe.Amount;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;

public class BankAccountTest {

    @Test
    public void when_a_bank_client_makes_a_deposit_in_an_empty_account_then_the_account_balance_is_the_amount_deposited() {
        Amount expectedAccountBalance = Amount.of(new BigDecimal(10.19));
        Amount initialAccountBalance = Amount.of(BigDecimal.ZERO);
        Account account = new Account(initialAccountBalance);
        Amount amountDeposited = Amount.of(BigDecimal.valueOf(10.19));

        account.deposit(amountDeposited);

        Assertions.assertThat(account.accountBalance).isEqualTo(expectedAccountBalance);
    }

    @Test
    public void when_a_bank_client_makes_a_deposit_then_the_account_balance_is_sum_between_the_amount_deposited_and_the_former_account_balance() {
        Amount expectedAccountBalance = Amount.of(BigDecimal.valueOf(20.13));
        Amount initialAccountBalance = Amount.of(BigDecimal.valueOf(10.19));
        Account account = new Account(initialAccountBalance);
        Amount amountDeposited = Amount.of(BigDecimal.valueOf(9.94));

        account.deposit(amountDeposited);

        Amount accountBalanceAfterDeposit = account.accountBalance;
        Assertions.assertThat(accountBalanceAfterDeposit).isEqualTo(expectedAccountBalance);
    }
}
