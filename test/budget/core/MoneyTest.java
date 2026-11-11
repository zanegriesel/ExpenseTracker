package budget.core;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void moneyFormattedCorrectly() {
        assertEquals("R8,43", Money.format(843));
        assertEquals("R857,39", Money.format(85739));
        assertEquals("R10,00", Money.format(1000));
        assertEquals("R0,01", Money.format(1));
    }

    @Test
    void negativeAmountIsRejected() {
        assertThrows(IllegalArgumentException.class, () -> new Expense(-500, Category.RENT, LocalDate.of(2026, 10, 10), "negative number"));
    }

    @Test
    void zeroAmountIsRejected() {
        assertThrows(IllegalArgumentException.class, () -> new Expense(0, Category.RENT, LocalDate.of(2026, 10, 10), "zero amount"));

    }
}