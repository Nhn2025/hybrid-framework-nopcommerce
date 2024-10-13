package pageObject.factory;

import commons.BasePage;
import commons.BasePageFactory;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends BasePageFactory {
    WebDriver driver;

    @FindBy(xpath = "//input[@id='Email']")
    @CacheLookup
    private WebElement emailTextbox;

    @FindBy(xpath = "//input[@id='Password']")
    @CacheLookup
    private WebElement passwordTextbox;

    @FindBy(xpath = "//button[@class='button-1 login-button']")
    @CacheLookup
    private WebElement loginButton;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickLoginButton() {
        waitForElementClickable(driver, loginButton);
        clickToElement(driver, loginButton);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, passwordTextbox);
        senKeyToElement(driver, passwordTextbox, password);
    }

    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, emailTextbox);
        senKeyToElement(driver, emailTextbox, emailAddress);
    }
}
