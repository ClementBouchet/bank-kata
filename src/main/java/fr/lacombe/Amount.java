package fr.lacombe;

import java.math.BigDecimal;
import java.util.Objects;

public class Amount {
    BigDecimal amount;

    private Amount(BigDecimal amount) {
        this.amount = amount;
    }

    public static Amount of(BigDecimal amount) {
        amount = amount.setScale(2, BigDecimal.ROUND_CEILING);
        return new Amount(amount);
    }

    Amount add(Amount amountDeposited) {
        return new Amount(amount.add(amountDeposited.amount));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount1 = (Amount) o;
        return Objects.equals(amount, amount1.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
