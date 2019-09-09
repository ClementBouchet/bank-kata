import fr.lacombe.Account;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;

public class BankAccountTest {

    @Test
    public void when_a_bank_client_makes_a_deposit_in_an_empty_account_then_the_account_balance_is_the_amount_deposited() {
        BigDecimal expectedAccountBalance = BigDecimal.valueOf(10.19);
        BigDecimal initialAccountBalance = BigDecimal.ZERO;
        Account account = new Account(initialAccountBalance);
        BigDecimal amountDeposited = BigDecimal.valueOf(10.19);

        account.deposit(amountDeposited);

        Assertions.assertThat(account.accountBalance).isEqualTo(expectedAccountBalance);
    }
}
