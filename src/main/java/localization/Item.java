package localization;

public class Item {
    String name;
    double price;
    double quantity;

    public Item(String name, double price, double quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotal() {
        return price * quantity;
    }
}
