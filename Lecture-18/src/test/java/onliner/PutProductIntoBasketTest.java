package onliner;

import constant.DriverType;
import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.BasketPage;
import page.HomePage;
import page.LoginPage;
import page.ProductPage;

public class PutProductIntoBasketTest {

    private static final String URL = "https://onliner.by";
    private static final String LOGIN = "Mexal17";
    private static final String PASS = "123";
    private WebDriver driver;
    private HomePage homePage;
    private ProductPage productPage;
    private BasketPage basketPage;

    @BeforeClass
    public void setup() {
        driver = DriverFactory.getInstance(DriverType.CHROME);
        driver.get(URL);
    }

    @Test
    public void loginTest() {
        homePage = new HomePage(driver);
        LoginPage loginPage = homePage.openLoginPage();
        homePage = loginPage.authentication(LOGIN, PASS);
        Assert.assertTrue(homePage.isProfileFrameDisplayed());
    }

    @Test(dependsOnMethods = "loginTest")
    public void chooseProductTest() {
        productPage = homePage.chooseProduct();
        Assert.assertTrue(homePage.isProductDescriptionFrameDisplayed());
    }

    @Test(dependsOnMethods = "chooseProductTest")
    public void putItemIntoBasketTest() {
        basketPage = productPage.putIntoBasket();
        Assert.assertTrue(!basketPage.isProductsAddedIntoBasket());
    }

    @Test(dependsOnMethods = "putItemIntoBasketTest")
    public void deleteItemsFromTheBasketTest() {
        basketPage.cleanBasket();
        Assert.assertTrue(basketPage.isBasketEmpty());
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
