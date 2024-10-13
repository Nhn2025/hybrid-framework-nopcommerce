package pageObject.factory;

import commons.BasePage;
import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends BasePageFactory {
    WebDriver driver;

    @FindBy(xpath = "//input[@id='FirstName']")
    @CacheLookup
    private WebElement firstnameTextbox;

    @FindBy(xpath = "//input[@id='LastName']")
    @CacheLookup
    private WebElement lastnameTextbox;

    @FindBy(xpath = "//input[@id='Email']")
    @CacheLookup
    private WebElement emailTextbox;

    @FindBy(xpath = "//input[@id='Password']")
    @CacheLookup
    private WebElement passwordTextbox;

    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    @CacheLookup
    private WebElement confirmPasswordTextbox;

    @FindBy(xpath = "//button[@id='register-button']")
    @CacheLookup
    private WebElement registerButton;

    @FindBy(xpath = "//span[@id='FirstName-error']")
    @CacheLookup
    private WebElement firstnameErrorMsg;

    @FindBy(xpath = "//span[@id='LastName-error']")
    @CacheLookup
    private WebElement lastnameErrorMsg;

    @FindBy(xpath = "//span[@id='Email-error']")
    @CacheLookup
    private WebElement emailErrorMsg;

    @FindBy(xpath = "//span[@class='field-validation-error']")
    @CacheLookup
    private WebElement passwordErrorMsg;

    @FindBy(xpath = "//span[@id='ConfirmPassword-error']")
    @CacheLookup
    private WebElement confirmPasswordErrorMsg;

    @FindBy(xpath = "//div[@class='result']")
    @CacheLookup
    private WebElement registrationCompletedMsg;

    @FindBy(xpath = "//div[@class='header-logo']//img")
    @CacheLookup
    private WebElement nopCommerceLogo;

    @FindBy(xpath = "//a[@class='ico-logout']")
    @CacheLookup
    private WebElement logoutButton;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, registerButton);
        clickToElement(driver, registerButton);
    }

    public String getFirstNameErrorMessageText() {
        waitForElementVisible(driver, firstnameErrorMsg);
        return getElementText(driver, firstnameErrorMsg);
    }

    public String getLastNameErrorMessageText() {
        waitForElementVisible(driver, lastnameErrorMsg);
        return getElementText(driver, lastnameErrorMsg);
    }

    public String getEmailErrorMessageText() {
        waitForElementVisible(driver, emailErrorMsg);
        return getElementText(driver, emailErrorMsg);
    }

    public String getConfirmPasswordErrorMessageText() {
        waitForElementVisible(driver, confirmPasswordErrorMsg);
        return getElementText(driver, confirmPasswordErrorMsg);
    }

    public void clickToNopCommerceLogo() {
        waitForElementClickable(driver, nopCommerceLogo);
        clickToElement(driver, nopCommerceLogo);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, firstnameTextbox);
        senKeyToElement(driver, firstnameTextbox, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, lastnameTextbox);
        senKeyToElement(driver, lastnameTextbox, lastName);
    }

    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, emailTextbox);
        senKeyToElement(driver, emailTextbox, emailAddress);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, passwordTextbox);
        senKeyToElement(driver, passwordTextbox, password);
    }

    public void enterToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementVisible(driver, confirmPasswordTextbox);
        senKeyToElement(driver, confirmPasswordTextbox, confirmPassword);
    }

    public String getPasswordErrorMessageText() {
        waitForElementVisible(driver, passwordErrorMsg);
        return getElementText(driver, passwordErrorMsg);
    }

    public String getRegisterSuccessMessageText() {
        waitForElementVisible(driver, registrationCompletedMsg);
        return getElementText(driver, registrationCompletedMsg);
    }

    public void clickToLogOutLink() {
        waitForElementClickable(driver, logoutButton);
        clickToElement(driver, logoutButton);
    }
}
