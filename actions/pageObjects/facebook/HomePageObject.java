package pageObjects.facebook;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.facebook.HomePageUI;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToCreateNewAccount() {
        waitForElementClickable(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
        clickToElement(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
    }

    public boolean isFirstNameTextboxDisplayed() {
        waitForElementVisible(driver, HomePageUI.FIRST_NAME_TEXTBOX);
        return isELementDisplayed(driver, HomePageUI.FIRST_NAME_TEXTBOX);
    }

    public boolean isSurNameTextboxDisplayed() {
        waitForElementVisible(driver, HomePageUI.SUR_NAME_TEXTBOX);
        return isELementDisplayed(driver, HomePageUI.SUR_NAME_TEXTBOX);
    }

    public boolean isEmailTextboxDisplayed() {
        waitForElementVisible(driver, HomePageUI.EMAIL_NAME_TEXTBOX);
        return isELementDisplayed(driver, HomePageUI.EMAIL_NAME_TEXTBOX);
    }

    public boolean isPasswordTextboxDisplayed() {
        waitForElementVisible(driver, HomePageUI.PASSWORD_NAME_TEXTBOX);
        return isELementDisplayed(driver, HomePageUI.PASSWORD_NAME_TEXTBOX);
    }

    public void enterToEmailTextbox(String emailAdress) {
        waitForElementVisible(driver, HomePageUI.EMAIL_NAME_TEXTBOX);
        sendKeyToElement(driver, HomePageUI.EMAIL_NAME_TEXTBOX, emailAdress);
    }

    public boolean isConfirmEmailTextboxDisplayed() {
        waitForElementVisible(driver, HomePageUI.CONFIRM_EMAIL_NAME_TEXTBOX);
        return isELementDisplayed(driver, HomePageUI.CONFIRM_EMAIL_NAME_TEXTBOX);
    }

    public void clickToCloseSignUpPopup() {
        waitForElementClickable(driver, HomePageUI.CLOSE_SIGNUP_POPUP_ICON);
        clickToElement(driver, HomePageUI.CLOSE_SIGNUP_POPUP_ICON);
        sleepInSecond(3);
    }

    public boolean isFirstNameTextboxUndisplayed() {
        return isElementUndisplayed(driver, HomePageUI.FIRST_NAME_TEXTBOX);
    }

    public boolean isSurNameTextboxUndisplayed() {
        return isElementUndisplayed(driver, HomePageUI.SUR_NAME_TEXTBOX);
    }

    public boolean isEmailTextboxUndisplayed() {
        return isElementUndisplayed(driver, HomePageUI.EMAIL_NAME_TEXTBOX);
    }

    public boolean isPasswordTextboxUndisplayed() {
        return isElementUndisplayed(driver, HomePageUI.PASSWORD_NAME_TEXTBOX);
    }
}
