package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Ник или e-mail']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passField;

    @FindBy(xpath = "//div/button[@type='submit']")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public HomePage authentication(String login, String pass) {
        loginField.sendKeys(login);
        passField.sendKeys(pass);
        submitButton.submit();
        return new HomePage(driver);
    }

}
