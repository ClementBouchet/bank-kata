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

public class AccountAcceptanceTest {

    @Test
    public void bank_user_makes_deposit_then_withdrawal_then_ask_for_account_statement_acceptance_test() {

        OperationType operationType1 = OperationType.DEPOSIT;
        LocalDateTime operationDate1 = LocalDateTime.of(2019, 1,1,12,0);
        Amount amountOfOperation1 = Amount.of(BigDecimal.valueOf(10));
        Amount accountBalance1 = Amount.of(BigDecimal.valueOf(150));

        OperationType operationType2 = OperationType.WITHDRAWAL;
        LocalDateTime operationDate2 = LocalDateTime.of(2019, 1,2,14,0);
        Amount amountOfOperation2 = Amount.of(BigDecimal.valueOf(50));
        Amount accountBalance2 = Amount.of(BigDecimal.valueOf(100));

        List<HistoryLine> historyLines = new ArrayList<>();
        historyLines.add(new HistoryLine(operationType1, operationDate1, amountOfOperation1, accountBalance1));
        historyLines.add(new HistoryLine(operationType2, operationDate2, amountOfOperation2, accountBalance2));
        AccountHistory expectedAccountHistory = new AccountHistory(historyLines);

        Account account = new Account(Amount.of(BigDecimal.valueOf(140)), new AccountHistory(new ArrayList<>()));


        account.deposit(amountOfOperation1, operationDate1);
        account.withdraw(amountOfOperation2, operationDate2);


        assertThat(account.getAccountHistory()).isEqualTo(expectedAccountHistory);
    }
}
