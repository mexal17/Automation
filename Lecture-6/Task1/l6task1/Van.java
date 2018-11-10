package l6task1;

import java.util.List;

public class Van {
    private final int maxValue;
    private List<Product> products;

    public Van(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
