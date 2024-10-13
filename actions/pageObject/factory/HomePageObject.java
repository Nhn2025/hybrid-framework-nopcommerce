package pageObject.factory;

import commons.BasePage;
import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject extends BasePageFactory {
    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
    @CacheLookup
    private WebElement registerLink;

    @FindBy(xpath = "//a[@class='ico-login']")
    @CacheLookup
    private WebElement loginLink;

    @FindBy(css = "a.ico-account")
    @CacheLookup
    private WebElement myAccountLink;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickToRegisterLink() {
        waitForElementClickable(driver, registerLink);
        clickToElement(driver, registerLink);
    }

    public void clickToMyAccountLink() {
        waitForElementClickable(driver, myAccountLink);
        clickToElement(driver, myAccountLink);
    }

    public void clickToLoginLink() {
        waitForElementClickable(driver, loginLink);
        clickToElement(driver, loginLink);
    }
}
