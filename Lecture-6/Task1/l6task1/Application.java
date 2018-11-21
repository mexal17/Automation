package l6task1;

public class Application {

    public static void main(String[] args) {
        Van van = new Van(3000);
        VanFiller.fillVan(van, ProductGenerator.getAllProducts(), 10000);
        System.out.println("\n------>Products in van:");
        ProductHelper.showElementsOfCollection(van.getProducts());
        System.out.println("\n-------> getSortedProductsByPrice:");
        ProductHelper.showElementsOfCollection(ProductCalculator.getSortedProductsByPrice(van.getProducts()));
        System.out.println("\n-------> Search products in List with params = sort -> arabica, weight -> 220: ");
        ProductHelper.showElementsOfCollection(ProductCalculator.findProducts(van.getProducts(), CoffeeSort.ROBUSTA.getSort(), 220));
    }
}
