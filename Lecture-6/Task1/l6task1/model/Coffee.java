package l6task1.model;

public class Coffee {

    private final String type;
    private final String sort;
    private final int price;

    public Coffee(String type, String sort, int price) {
        this.type = type;
        this.sort = sort;
        this.price = price;
    }

    public String getSort() {
        return sort;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "" + sort + " - " + type + " - pr:" + price;
    }
}
