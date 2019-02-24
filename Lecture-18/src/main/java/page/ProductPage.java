package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections;
import java.util.List;

public class ProductPage {
    private final WebDriver driver;

    @FindBy(css = ".button.button_orange.button_big.offers-description__button")
    private WebElement showSellersButton;

    @FindBys({@FindBy(xpath = "//td[@class='b-cell-3']/a")})
    List<WebElement> sellers;

    @FindBy(xpath = "//a[text()='В корзине']")
    WebElement openBasketButton;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public BasketPage putIntoBasket() {
        showSellersButton.click();
        Collections.shuffle(sellers);
        sellers.get(0).click();
        openBasketButton.click();
        return new BasketPage(driver);
    }
}
