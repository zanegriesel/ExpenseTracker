package budget.core;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.YearMonth;

import static org.junit.jupiter.api.Assertions.*;

class BudgetServiceTest {

    @Test
    void totalOfEmptyServiceIsZero() {
        BudgetService service = new BudgetService();
        assertEquals(0, service.getTotal());
    }

    @Test
    void totalAddsAllExpenses() {
        // Arrange: set up the situation
        BudgetService service = new BudgetService();
        service.addExpense(new Expense(4550, Category.FOOD, LocalDate.now(), "Lunch"));
        service.addExpense(new Expense(2000, Category.TRANSPORT, LocalDate.now(), "Taxi"));

        // Act: do the thing being tested
        long total = service.getTotal();

        // Assert: check the result
        assertEquals(6550, total);
    }

    @Test
    void totalForCategoryOnlyCountsThatCategory() {
        // Arrange
        BudgetService service = new BudgetService();
        LocalDate day = LocalDate.of(2026, 11, 11);
        service.addExpense(new Expense(5000, Category.FOOD, day, "Groceries"));
        service.addExpense(new Expense(2500, Category.FOOD, day, "Takeaway"));
        service.addExpense(new Expense(9000, Category.TRANSPORT, day, "Taxi"));

        // Act
        long foodTotal = service.getTotalForCategory(Category.FOOD);

        // Assert
        assertEquals(7500, foodTotal);
    }

    @Test
    void totalForMonthExcludesOtherMonths() {
        BudgetService service = new BudgetService();
        LocalDate november = LocalDate.of(2026, 11, 11);
        LocalDate wrongMonth = LocalDate.of(2026, 9, 11);
        LocalDate rightMonthWrongYear = LocalDate.of(2025, 11, 11);
        service.addExpense(new Expense(5000, Category.FOOD, november, "Groceries"));
        service.addExpense(new Expense(2500, Category.FOOD, november, "Takeaway"));
        service.addExpense(new Expense(9000, Category.FOOD, wrongMonth, "Snack"));
        service.addExpense(new Expense(3000, Category.FOOD, rightMonthWrongYear, "Drive-Through"));

        long novemberTotal = service.getTotalForMonth(YearMonth.of(2026, 11));

        assertEquals(7500, novemberTotal);
    }
}