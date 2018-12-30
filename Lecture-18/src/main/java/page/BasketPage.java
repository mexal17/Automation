package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasketPage {
    private final WebDriver driver;

    @FindBys({@FindBy(className = "cart-product")})
    private List<WebElement> productsInBasket;

    @FindBys({@FindBy(xpath = "//a[@title='Удалить']")})
    private List<WebElement> deleteFromBasketButtons;

    @FindBy(xpath = "//a[text()='историю заказов']")
    private WebElement emptyBasket;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public boolean isProductsAddedIntoBasket() {
        return productsInBasket.isEmpty();
    }

    public void cleanBasket() {
        deleteFromBasketButtons.forEach(WebElement::click);
    }

    public boolean isBasketEmpty() {
        return emptyBasket.isDisplayed();
    }
}
