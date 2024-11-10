package pageObjects.user;

import commons.BaseElement;
import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.user.RegisterPageUI;

public class RegisterPageObject extends BaseElement {
    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click To Register Button")
    public void clickToRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    @Step("Get FirstName Error Message Text")
    public String getFirstNameErrorMessageText() {
        waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_ERROR_MSG);
        return getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR_MSG);
    }

    @Step("Get LastName Error Message Text")
    public String getLastNameErrorMessageText() {
        waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR_MSG);
        return getElementText(driver, RegisterPageUI.LASTNAME_ERROR_MSG);
    }

    @Step("Get Email Error Message Text")
    public String getEmailErrorMessageText() {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MSG);
        return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MSG);
    }

    @Step("Get Password Error Message Text")
    public String getPasswordErrorMessageText() {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MSG);
        return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MSG);
    }

    @Step("Get Confirm Password Error Message Text")
    public String getConfirmPasswordErrorMessageText() {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
        return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
    }

    @Step("Click To Logout Link")
    public HomePageObject clickToLogoutLink() {
        waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
        clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
        return PageGeneratorManager.getHomePage(driver);
    }

    @Step("Enter to First Name textbox with value: {0}")
    public void enterToFirstNameTextbox(String firstNameValue) {
        waitForElementClickable(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstNameValue);
    }

    @Step("Enter to Last Name textbox with value: {0}")
    public void enterToLastNameTextbox(String lastNameValue) {
        waitForElementClickable(driver, RegisterPageUI.LASTNAME_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastNameValue);
    }

    @Step("Enter to Email textbox with value: {0}")
    public void enterToEmailTextbox(String emailAddressValue) {
        waitForElementClickable(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddressValue);
    }

    @Step("Enter to Password textbox with value: {0}")
    public void enterToPasswordTextbox(String passwordValue) {
        waitForElementClickable(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, passwordValue);
    }

    @Step("Enter to Confirm Password textbox with value: {0}")
    public void enterToConfirmPasswordTextbox(String passwordValue) {
        waitForElementClickable(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, passwordValue);
    }

    @Step("Get Register Success Message Text")
    public String getRegisterSuccessMessageText() {
        waitForElementVisible(driver, RegisterPageUI.REGISTRATION_COMPLETED_MSG);
        return getElementText(driver, RegisterPageUI.REGISTRATION_COMPLETED_MSG);
    }
}
