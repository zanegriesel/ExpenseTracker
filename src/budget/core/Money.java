package budget.core;

public class Money {

    public static String format(long cents) {
        long rands = cents / 100;
        long remainingCents = cents % 100;

        return String.format("R%d,%02d", rands, remainingCents);
    }
}
