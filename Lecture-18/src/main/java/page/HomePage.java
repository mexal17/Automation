package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections;
import java.util.List;

public class HomePage {

    private final WebDriver driver;

    @FindBy(xpath = "//div[contains(text(),'Вход')]")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='b-top-profile__list']")
    private WebElement profileFrame;

    @FindBy(xpath = "//span[text()='Каталог']/..")
    private WebElement catalogButton;

    @FindBys({@FindBy(css = ".catalog-bar__link.catalog-bar__link_strong")})
    private List<WebElement> sections;

    @FindBys({@FindBy(xpath = "//div[@class='schema-product__title']")})
    private List<WebElement> products;

    @FindBy(xpath = "//main[@class='product-main']")
    private WebElement productDescriptionFrame;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public LoginPage openLoginPage() {
        loginButton.click();
        return new LoginPage(driver);
    }

    public ProductPage chooseProduct() {
        catalogButton.click();
        Collections.shuffle(sections);
        sections.get(0).click();
        Collections.shuffle(products);
        products.get(0).click();
        return new ProductPage(driver);
    }

    public boolean isProfileFrameDisplayed() {
        return profileFrame.isDisplayed();
    }

    public boolean isProductDescriptionFrameDisplayed() {
        return productDescriptionFrame.isDisplayed();
    }
}
