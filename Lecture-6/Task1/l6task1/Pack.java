package l6task1;

public class Pack {
    private final String type;
    private final int value;
    private int price;
    private int capacity;

    public Pack(String type, int value, int price, int capacity) {
        this.type = type;
        this.value = value;
        this.price = price;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "" + type + ", val:" + value + ", pr:" + price + ", cap:" + capacity;
    }
}
