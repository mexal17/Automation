package l6task1;

public class Coffee {

    private final String type;
    private final String sort;
    private int price;

    public Coffee(String type, String sort, int price) {
        this.type = type;
        this.sort = sort;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public String getSort() {
        return sort;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "" + sort + " - " + type + " - pr:" + price;
    }
}
