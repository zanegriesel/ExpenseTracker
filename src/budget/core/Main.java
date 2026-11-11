package budget.core;

import java.time.LocalDate;
import java.time.YearMonth;

public class Main {
    public static void main(String[] args) {
        Expense lunch = new Expense(4550, Category.FOOD, LocalDate.now(), "Lunch on campus");
        Expense taxi = new Expense(2000, Category.TRANSPORT, LocalDate.now(), "Taxi to town");
        Expense rent = new Expense(7000, Category.RENT, LocalDate.of(2026, 10, 14), "");
        System.out.println(lunch);
        System.out.println(taxi);

        BudgetService service = new BudgetService();
        service.addExpense(lunch);
        service.addExpense(taxi);
        System.out.println(Money.format(service.getTotal()));

        System.out.println(Money.format(6335));

        System.out.println(rent);
        service.addExpense(rent);

        System.out.println(service.getTotalForMonth(YearMonth.now()));
        System.out.println(Money.format(service.getTotalForMonth(YearMonth.of(2026, 10))));


    }
}
