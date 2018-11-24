package l6task1;

public class Application {

    public static void main(String[] args) {
        ProductGenerator.readProductDataFromFile();
        Van van = new Van(3000);
        VanFiller.fillVan(van, ProductGenerator.getAllProducts(), 10000);
        System.out.println("\n------>Products in van:");
        ProductHelper.printElementsOfCollection(van.getProducts());
        System.out.println("\n-------> getSortedProductsByPrice:");
        ProductHelper.printElementsOfCollection(ProductCalculator.getSortedProductsByPrice(van.getProducts()));
        System.out.println("\n-------> Search products in List with params = sort -> ROBUSTA, weight -> 220: ");
        ProductHelper.printElementsOfCollection(ProductCalculator.findProducts(van.getProducts(), CoffeeSort.ROBUSTA.name(), 220));
    }
}
