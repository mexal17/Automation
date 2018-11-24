package l6task1;

public class Product {
    private final Coffee coffee;
    private final Pack pack;
    private final String brand;
    private final int price;
    private final int weight;

    public Product(Coffee coffee, Pack pack, String brand) {
        this.coffee = coffee;
        this.pack = pack;
        this.brand = brand;
        this.price = coffee.getPrice() * pack.getCapacity() + pack.getPrice();
        this.weight = pack.getCapacity() + pack.getWeight();
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "br: " + brand + ", pr: " + price + ", w: " + weight + " ||| Coffee = " + coffee.toString() + " ||| Pack = " + pack.toString();
    }
}
