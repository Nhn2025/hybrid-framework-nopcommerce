package pageObject.factory;

import commons.BasePage;
import commons.BasePageFactory;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.XMLFormatter;

public class CustomerPageObject extends BasePageFactory {
    WebDriver driver;

    @FindBy(id = "FirstName")
    @CacheLookup
    private WebElement firstNameTextbox;

    @FindBy(id = "LastName")
    @CacheLookup
    private WebElement lastNameTextbox;

    @FindBy(id = "Email")
    @CacheLookup
    private WebElement emailTextbox;

    public CustomerPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String getEmailAddressTextboxAttributeValue() {
        waitForElementVisible(driver, emailTextbox);
        return getElementAttribute(driver, emailTextbox, "value");
    }

    public String getLastNameTextboxAttributeValue() {
        waitForElementVisible(driver, lastNameTextbox);
        return getElementAttribute(driver, lastNameTextbox, "value");
    }

    public String getFirstNameTextboxAttributeValue() {
        waitForElementVisible(driver, firstNameTextbox);
        return getElementAttribute(driver, firstNameTextbox, "value");
    }
}
