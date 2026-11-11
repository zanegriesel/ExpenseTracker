package budget.core;

import java.time.LocalDate;

public class Expense {

    private final long amountInCents;
    private final Category category;
    private final LocalDate date;
    private final String description;

    public Expense(long amountInCents, Category category, LocalDate date, String subscription) {
        if (amountInCents <= 0) {
            throw new IllegalArgumentException("Invalid amount.");
        }
        this.amountInCents = amountInCents;
        this.category = category;
        this.date = date;
        this.description = subscription;
    }

    public long getAmountInCents() {
        return amountInCents;
    }

    public Category getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getSubscription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("%s  %s %s  (%s)",
                date, Money.format(amountInCents), description, category);
    }
}
