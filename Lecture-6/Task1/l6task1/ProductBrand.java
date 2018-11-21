package l6task1;

public enum ProductBrand {

    NESCAFE("Nescafe"), PELE("Pele"), TCHIBO("Tchibo");

    private String brand;

    ProductBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}
