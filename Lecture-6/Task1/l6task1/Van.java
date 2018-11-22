package l6task1;

import java.util.ArrayList;
import java.util.List;

public class Van {
    private final int vanCapacity;
    private List<Product> products;

    public Van(int maxValue) {
        this.vanCapacity = maxValue;
        this.products = new ArrayList<>();
    }

    public int getVanCapacity() {
        return vanCapacity;
    }

    public List<Product> getProducts() {
        return products;
    }
}
