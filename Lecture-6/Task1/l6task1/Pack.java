package l6task1;

public class Pack {
    private final String type;
    private final int weight;
    private final int price;
    private final int capacity;

    public Pack(String type, int weight, int price, int capacity) {
        this.type = type;
        this.weight = weight;
        this.price = price;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "" + type + ", w: " + weight + ", pr: " + price + ", cap: " + capacity;
    }
}
