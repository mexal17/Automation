package l6task1;

public class Product {
    private final Coffee coffee;
    private final Pack pack;
    private final String brand;
    private int price;
    private int value;

    public Product(Coffee coffee, Pack pack, String brand) {
        this.coffee = coffee;
        this.pack = pack;
        this.brand = brand;
        this.price = coffee.getPrice() * pack.getCapacity() + pack.getPrice();
        this.value = pack.getCapacity() + pack.getValue();
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public Pack getPack() {
        return pack;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + brand + ", pr: " + price + ", val: " + value + "| Coffee: " + coffee.toString() + "| Pack: " + pack.toString();
    }
}
