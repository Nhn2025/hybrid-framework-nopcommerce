package pageObjects.user;

import commons.BaseElement;
import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.user.HomePageUI;

public class HomePageObject extends BaseElement {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click To Register Link")
    public RegisterPageObject clickToRegisterLink() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
        return PageGeneratorManager.getRegisterPage(driver);
    }

    @Step("Click To Login Link")
    public UserLoginPageObject clickToLoginLink() {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
        return PageGeneratorManager.getUserLoginPage(driver);
    }

    @Step("Click To My Account Link")
    public CustomerPageObject clickToMyAccountLink() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
        return PageGeneratorManager.getCustomerPage(driver);
    }

    @Step("Click To Logout Link")
    public void clickToLogoutLink() {
        waitForElementClickable(driver, HomePageUI.LOG_OUT_LINK);
        clickToElement(driver, HomePageUI.LOG_OUT_LINK);
    }

    @Step("Open My Account Link")
    public CustomerPageObject openMyAccountLink() {
        String myAccountLink = getElementAtrribute(driver, HomePageUI.MY_ACCOUNT_LINK, "href");
        openPageUrl(driver, myAccountLink);
        return PageGeneratorManager.getCustomerPage(driver);
    }

    @Step("Verify Register link is displayed")
    public boolean isRegisterLinkDisplayed() {
        waitForElementVisible(driver, HomePageUI.REGISTER_LINK);
        return isELementDisplayed(driver, HomePageUI.REGISTER_LINK);
    }

}
