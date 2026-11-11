package budget.core;

import java.util.ArrayList;
import java.util.List;
import java.time.YearMonth;
import java.util.function.Predicate;

public class BudgetService {

    private final List<Expense> expenses = new ArrayList<>();

    public void addExpense(Expense e) {
        expenses.add(e);
    }

    //helper method to get total of various conditions with one implemtation
    private long sumWhere(Predicate<Expense> condition) {
        long total = 0;
        for (Expense e : expenses) {
            if (condition.test(e)) {
                total += e.getAmountInCents();
            }
        }
        return total;
    }

    //methods that get various totals and use the helper method.
    public long getTotal() {
        return sumWhere(e -> true);
    }

    public long getTotalForCategory(Category c) {
        return sumWhere(e -> e.getCategory().equals(c));
    }

    public long getTotalForMonth(YearMonth month) {
        return sumWhere(e -> YearMonth.from(e.getDate()).equals(month));
    }

}
