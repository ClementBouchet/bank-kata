import fr.lacombe.Account;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;

public class BankAccountTest {

    @Test
    public void a_bank_client_makes_a_deposit() {
        BigDecimal expectedAccountBalance = BigDecimal.valueOf(10.19);
        BigDecimal accountBalance = BigDecimal.ZERO;
        Account account = new Account(accountBalance);
        BigDecimal amountDeposited = BigDecimal.valueOf(10.19);

        account.deposit(amountDeposited);

        Assertions.assertThat(account.accountBalance).isEqualTo(expectedAccountBalance);
    }
}
