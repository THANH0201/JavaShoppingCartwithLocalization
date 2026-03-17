package localization;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CartCalculatorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculateTotal() {
        HashMap<String, Item> cart = new HashMap<>();
        cart.put("Apple", new Item("Apple", 2.0, 2.0));   // 4
        cart.put("Banana", new Item("Banana", 1.5, 2.0)); // 3

        double total = CartCalculator.calculateTotal(cart);
        assertEquals(7.0, total);
    }


    @Test
    void applyDiscount() {
        double total = 10.0;
        double discounted = CartCalculator.applyDiscount(total);
        assertEquals(9.0, discounted); // discount 10%
    }

    @Test
    void testDiscountNotApplied() {
        double total = 4.0;
        double discounted = CartCalculator.applyDiscount(total);
        assertEquals(3.6, discounted); // no discount
    }

    @Test
    void testTax() {
        double amount = 10.0;
        double taxed = CartCalculator.applyTax(amount);
        assertEquals(12.4, taxed);
    }

    @Test
    void testFullCalculation() {
        HashMap<String, Item> cart = new HashMap<>();
        cart.put("Apple", new Item("Apple", 2.0, 2.0)); // 4
        cart.put("Banana", new Item("Banana", 1.0, 2.0)); // 2

        double total = CartCalculator.calculateTotal(cart); // 6
        double discounted = CartCalculator.applyDiscount(total); // 5.4
        double finalCost = CartCalculator.applyTax(discounted); // 6.696

        assertEquals(6.696, finalCost, 0.0001);
    }
}