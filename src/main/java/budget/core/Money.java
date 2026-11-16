package budget.core;

public class Money {

    public static String format(long cents) {
        long rands = cents / 100;
        long remainingCents = cents % 100;

        return String.format("R%d.%02d", rands, remainingCents);
    }

    public static long parse(String rands) {
        int digitsAfterDot = 0;
        if (rands.contains(".")) {
            digitsAfterDot = rands.length() - rands.indexOf(".") - 1;
            if (digitsAfterDot == 1) {
                rands += "0";
            }
            rands = rands.replace(".", "");
            return Long.parseLong(rands);
        } else {
            return Long.parseLong(rands) * 100;
        }
    }
}
