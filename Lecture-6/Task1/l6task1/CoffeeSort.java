package l6task1;

public enum CoffeeSort {
    ARABICA("Arabica"), ROBUSTA("Robusta");

    private String sort;

    CoffeeSort(String sort) {
        this.sort = sort;
    }

    public String getSort() {
        return sort;
    }
}
