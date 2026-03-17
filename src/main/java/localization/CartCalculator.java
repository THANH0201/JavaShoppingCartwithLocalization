package localization;

import java.util.HashMap;

public class CartCalculator {

    public static double calculateTotal(HashMap<String, Item> cart) {
        double total = 0;
        for (String name : cart.keySet()) {
            total += cart.get(name).getTotal();
        }
        return total;
    }

    public static double applyDiscount(double total) {
        return total * 0.9; // 10% discount
    }

    public static double applyTax(double amount) {
        return amount * 1.24; // VAT 24%
    }
}
