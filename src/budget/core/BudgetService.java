package budget.core;

import java.util.ArrayList;
import java.util.List;
import java.time.YearMonth;

public class BudgetService {

    private final List<Expense> expenses = new ArrayList<>();

    public void addExpense(Expense e) {
        expenses.add(e);
    }

    public long getTotal() {
        long total = 0;
        for (Expense e : expenses) {
            total += e.getAmountInCents();
        }
        return total;
    }

    public long getTotalForCategory(Category c) {
        long total = 0;
        for (Expense e : expenses) {
            if (e.getCategory() == c) {
                total += e.getAmountInCents();
            }
        }
        return total;
    }

    public long getTotalForMonth(YearMonth month) {
        long total = 0;
        for (Expense e : expenses) {
            if (YearMonth.from(e.getDate()).equals(month)) {
                total += e.getAmountInCents();
            }
        }
        return total;
    }

}
