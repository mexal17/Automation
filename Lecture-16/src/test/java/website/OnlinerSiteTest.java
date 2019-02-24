package website;

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
import java.util.concurrent.TimeUnit;

public class OnlinerSiteTest {
    private static final String URL = "https://onliner.by";
    private static final String AUTH_BUTTON = "//div[contains(text(),'Вход')]";
    private static final String LOGIN_FIELD = "//input[@placeholder='Ник или e-mail']";
    private static final String PASS_FIELD = "//input[@type='password']";
    private static final String SUBMIT_BUTTON = "//div/button[@type='submit']";
    private static final String PROFILE_FRAME = "//div[@class='b-top-profile__list']";
    private static final String PRODUCTS_XPATH = "//div[@class='schema-product__title']";
    private static final String SECTIONS_CSS_SELECTOR = ".catalog-bar__link.catalog-bar__link_strong";
    private static final String LOGIN = "Mexal17";
    private static final String PASS = "ptyaes106818";
    private static final String CATALOG_XPATH = "//span[text()='Каталог']/..";
    private static final String SELLERS_CSS_SELECTOR = ".button.button_orange.button_big.offers-description__button";
    private static final String PUT_INTO_BASKET_XPATH = "//td[@class='b-cell-3']/a";
    private static final String OPEN_BASKET_XPATH = "//a[text()='В корзине']";
    private static final String PRODUCTS_IN_BASKET = "cart-product";
    private static final String DELETE_ITEMS_XPATH = "//a[@title='Удалить']";
    private static final String NO_ITEMS_XPATH = "//a[text()='историю заказов']";
    private static final String DRIVER_TYPE = "webdriver.chrome.driver";
    private static final String DRIVER_PATH = "./src/test/resources/chromedriver.exe";
    private static final String PRODUCTS_FRAME_XPATH = "//main[@class='product-main']";

    private WebDriver driver;
    private Wait<WebDriver> wait;

    private void clickOnRandomElement(List<WebElement> elements){
        Collections.shuffle(elements);
        elements.get(0).click();
    }

    @BeforeClass
    public void setup() {
        System.setProperty(DRIVER_TYPE, DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        Duration waitTime = Duration.ofSeconds(10);
        Duration interval = Duration.ofMillis(100);
        wait = new FluentWait<WebDriver>(driver).withTimeout(waitTime).pollingEvery(interval).ignoring(NoSuchElementException.class);
    }

    @Test
    public void logInTest() {
        driver.findElement(By.xpath(AUTH_BUTTON)).click();
        driver.findElement(By.xpath(LOGIN_FIELD)).sendKeys(LOGIN);
        driver.findElement(By.xpath(PASS_FIELD)).sendKeys(PASS);
        wait.until(webDriver -> driver.findElement(By.xpath(SUBMIT_BUTTON))).click();
        Assert.assertNotNull(wait.until(webDriver -> driver.findElement(By.xpath(PROFILE_FRAME))));
    }

    @Test(dependsOnMethods = "logInTest")
    public void chooseProductTest() {
        wait.until(webDriver -> driver.findElement(By.xpath(CATALOG_XPATH))).click();
        List<WebElement> sections = wait.until(webDriver -> driver.findElements(By.cssSelector(SECTIONS_CSS_SELECTOR)));
        System.out.println("sections.size = " + sections.size());
        clickOnRandomElement(sections);
        List<WebElement> products = wait.until(webDriver -> driver.findElements(By.xpath(PRODUCTS_XPATH)));
        System.out.println("products.size() = " + products.size());
        clickOnRandomElement(products);
        Assert.assertNotNull(driver.findElement(By.xpath(PRODUCTS_FRAME_XPATH)));
    }

    @Test(dependsOnMethods = "chooseProductTest")
    public void putIntoBasketTest() {
        driver.findElement(By.cssSelector(SELLERS_CSS_SELECTOR)).click();
        List<WebElement> sellers = driver.findElements(By.xpath(PUT_INTO_BASKET_XPATH));
        clickOnRandomElement(sellers);
        System.out.println("sellers.size() = " + sellers.size());
        wait.until(webDriver -> driver.findElement(By.xpath(OPEN_BASKET_XPATH))).click();
        List<WebElement> chosenItems = wait.until(webDriver -> driver.findElements(By.className(PRODUCTS_IN_BASKET)));
        System.out.println("chosenItems.size() = " + chosenItems.size());
        Assert.assertTrue(!chosenItems.isEmpty());
    }

    @Test(dependsOnMethods = "putIntoBasketTest")
    public void deleteItemFromTheBasketTest() {
        List<WebElement> itemsInBasket = wait.until(webDriver -> driver.findElements(By.xpath(DELETE_ITEMS_XPATH)));
        itemsInBasket.forEach(WebElement::click);
        Assert.assertNotNull(wait.until(webDriver -> driver.findElement(By.xpath(NO_ITEMS_XPATH))));
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
