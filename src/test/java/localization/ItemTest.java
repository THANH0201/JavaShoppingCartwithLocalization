package localization;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    @Test
    void testGetTotal() {
        Item item = new Item("Apple", 2.0, 3.0);
        assertEquals(6.0, item.getTotal());
    }

    @Test
    void testZeroQuantity() {
        Item item = new Item("Banana", 1.5, 0);
        assertEquals(0.0, item.getTotal());
    }

    @Test
    void testZeroPrice() {
        Item item = new Item("Orange", 0, 5);
        assertEquals(0.0, item.getTotal());
    }

    @Test
    void testDecimalValues() {
        Item item = new Item("Watermelon", 2.5, 1.2);
        assertEquals(3.0, item.getTotal(), 0.0001);
    }
}
