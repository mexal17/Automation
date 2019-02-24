package factory;

import constant.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String CHROME_DRIVER_PATH = "./src/main/resources/chromedriver.exe";
    private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
    private static final String FIREFOX_DRIVER_PATH = "./src/main/resources/geckodriver.exe";
    private static final String OPERA_DRIVER_PROPERTY = "webdriver.opera.driver";
    private static final String OPERA_DRIVER_PATH = "./src/main/resources/operadriver.exe";

    private DriverFactory() {
    }

    public static WebDriver getInstance(DriverType driverType) {
        switch (driverType) {
            case CHROME:
                System.setProperty(CHROME_DRIVER_PROPERTY, CHROME_DRIVER_PATH);
                WebDriver chromeDriver = new ChromeDriver();
                setupDriverSettings(chromeDriver);
                return chromeDriver;
            case FIREFOX:
                System.setProperty(FIREFOX_DRIVER_PROPERTY, FIREFOX_DRIVER_PATH);
                WebDriver firefoxDriver = new FirefoxDriver();
                setupDriverSettings(firefoxDriver);
                return firefoxDriver;
            case OPERA:
                System.setProperty(OPERA_DRIVER_PROPERTY, OPERA_DRIVER_PATH);
                WebDriver operaDriver = new OperaDriver();
                setupDriverSettings(operaDriver);
                return operaDriver;
            default:
                return null;
        }
    }

    private static void setupDriverSettings(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
}
