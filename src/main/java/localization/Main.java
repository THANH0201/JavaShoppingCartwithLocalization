package localization;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Locale locale = LanguageSelector.selectLanguage();
        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", locale);

        // Shopping cart
        HashMap<String, Item> cart = new HashMap<>();

        // List items
        HashMap<Integer, String> items = new HashMap<>();
        items.put(1, rb.getString("item.apple"));
        items.put(2, rb.getString("item.banana"));
        items.put(3, rb.getString("item.orange"));
        items.put(4, rb.getString("item.watermelon"));
        items.put(5, rb.getString("item.pineapple"));

        while (true) {
            try {
                System.out.println(rb.getString("welcome"));

                // Display items
                for (int key : items.keySet()) {
                    System.out.println(key + ". " + items.get(key));
                }

                System.out.println(rb.getString("enter.items"));
                int n = sc.nextInt();
                String name = items.get(n);

                System.out.println(rb.getString("enter.price"));
                double price = sc.nextDouble();

                System.out.println(rb.getString("enter.quantity"));
                double quantity = sc.nextDouble();

                Item item = new Item(name, price, quantity);
                cart.put(name, item);

                System.out.println(rb.getString("added") + " " + name +
                        " | price: " + price +
                        " | quantity: " + quantity +
                        " | total: " + item.getTotal());

                System.out.println(rb.getString("add.more"));
                String ans = sc.next();
                if (ans.equalsIgnoreCase("n")) break;

            } catch (InputMismatchException ex) {
                System.out.println(rb.getString("error.integer"));
                sc.nextLine(); // clear buffer
            }
        }

        // TOTAL CALCULATION
        double total = CartCalculator.calculateTotal(cart);

        System.out.println(rb.getString("total") + " " + String.format("%.2f", total) + " EUR");

        if (total >= 5) {
            System.out.println(rb.getString("discount"));
            total = CartCalculator.applyDiscount(total);
        }

        System.out.println(rb.getString("total.after.discount") + " " + String.format("%.2f", total) + " EUR");

        System.out.println(rb.getString("tax"));
        total = CartCalculator.applyTax(total);

        System.out.println(rb.getString("total.after.tax") + " " + String.format("%.2f", total) + " EUR");

        // PAYMENT
        System.out.println(rb.getString("pay"));
        String pay = sc.next();

        if (pay.equalsIgnoreCase("y")) {
            System.out.println(rb.getString("thanks"));
        } else {
            System.out.println(rb.getString("sorry"));
        }
    }
}
