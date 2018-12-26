import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class OnlinerSiteTest {
    private static String URL = "https://onliner.by";
    private static String REG1 = "//div[@class='auth-bar__item auth-bar__item--text']";
    private static String REG2 = "//input[@type='text' and @class='auth-input auth-input_primary auth-input_base auth-form__input auth-form__input_width_full']";
    private static String REG3 = "//input[@type='password' and @class='auth-input auth-input_primary auth-input_base auth-form__input auth-form__input_width_full']";
    private static String REG4 = "//button[@type='submit' and @class='auth-button auth-button_primary auth-button_middle auth-form__button auth-form__button_width_full']";
    private static String PRODUCTS_XPATH = "//div[@class='schema-product__title']/a";
    private static String SECTIONS_CSS_SELECTOR = ".catalog-bar__link.catalog-bar__link_strong";
    private static String AUTH_BAR_CSS_SELECTOR = ".auth-bar.auth-bar--top";
    private static String LOGIN = "Mexal17";
    private static String PASS = "ptyaesq106818";
    private static String CATALOG_XPATH = "//span[text()='Каталог']/..";
    private static String SELLERS_CSS_SELECTOR = ".button.button_orange.button_big.offers-description__button";
    private static String PUT_INTO_BASKET_CSS_SELECTOR = ".button.button_orange.button_middle.offers-list__button.offers-list__button_basket";
    private static String OPEN_BASKET_XPATH = ".button.button_orange.button_middle.offers-list__button.offers-list__button_basket.offers-list__button_checked";
    private static String ITEMS_CLASS_NAME = "cart-product";
    private static String DELETE_CLASS_NAME = "cart-product__remove";
    private static String NO_ITEMS_CSS_SELECTOR = ".cart-message.cart-message_empty";

    private WebDriver driver;
    private Wait<WebDriver> wait;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        Duration waitTime = Duration.ofSeconds(10);
        Duration interval = Duration.ofMillis(10);
        wait = new FluentWait<WebDriver>(driver).withTimeout(waitTime).pollingEvery(interval).ignoring(NoSuchElementException.class);
    }

    @Test
    public void registrationTest() {
        driver.findElement(By.xpath(REG1)).click();
        driver.findElement(By.xpath(REG2)).sendKeys(LOGIN);
        driver.findElement(By.xpath(REG3)).sendKeys(PASS);
        wait.until(webDriver -> driver.findElement(By.xpath(REG4))).click();
        Assert.assertNull(driver.findElement(By.cssSelector(AUTH_BAR_CSS_SELECTOR)));
    }

    @Test(dependsOnMethods = "registrationTest")
    public void chooseProductTest() {
        wait.until(webDriver -> driver.findElement(By.xpath(CATALOG_XPATH))).click();
        List<WebElement> sections = wait.until(webDriver -> driver.findElements(By.cssSelector(SECTIONS_CSS_SELECTOR)));
        Collections.shuffle(sections);
        sections.get(0).click();
        System.out.println("sections.size = " + sections.size());
        List<WebElement> products = wait.until(webDriver -> driver.findElements(By.xpath(PRODUCTS_XPATH)));
        Collections.shuffle(products);
        products.get(0).click();
        System.out.println("products.size() = " + products.size());
        Assert.assertNotEquals(0, products.size());
    }

    @Test(dependsOnMethods = "chooseProductTest")
    public void putIntoBasketTest() {
        driver.findElement(By.cssSelector(SELLERS_CSS_SELECTOR)).click();
        driver.findElement(By.cssSelector(PUT_INTO_BASKET_CSS_SELECTOR)).click();
        wait.until(webDriver -> driver.findElement(By.cssSelector(OPEN_BASKET_XPATH))).click();
        List<WebElement> items = wait.until(webDriver -> driver.findElements(By.className(ITEMS_CLASS_NAME)));
        System.out.println("items.size() = " + items.size());
        Assert.assertNotEquals(0, items.size());
    }

    @Test(dependsOnMethods = "putIntoBasketTest")
    public void deleteItemsFromTheBasketTest() {
        List<WebElement> deleteButtons = wait.until(webDriver -> driver.findElements(By.className(DELETE_CLASS_NAME)));
        for (WebElement element : deleteButtons) {
            element.click();
        }
        Assert.assertNotNull(driver.findElement(By.cssSelector(NO_ITEMS_CSS_SELECTOR)));
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
