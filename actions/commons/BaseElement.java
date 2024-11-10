package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.user.HomePageObject;
import pageUIs.user.BaseElementUI;

public class BaseElement extends BasePage {
    WebDriver driver;

    public BaseElement(WebDriver driver) {
        this.driver = driver;
    }

    // Hàm này theo business là bất kì hàm nào cũng nhìn thấy và thao tác lên nó được
    public HomePageObject clickToNopCommerceLogo() {
        waitForElementClickable(driver, BaseElementUI.NOP_COMMERCE_LOGO);
        clickToElement(driver, BaseElementUI.NOP_COMMERCE_LOGO);
        return PageGeneratorManager.getHomePage(driver);
    }

    // Theo business thì bất kì page nào cũng gọi ra dùng được
    public void clickToHeaderLinkByName(String pageName) {
        waitForElementClickable(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);
        clickToElement(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);
    }

    // Thao tác vs bất kì 1 button ở page nào
    public void clickToButtonByText(String buttonText) {
        waitForElementClickable(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
        clickToElement(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
    }

    // Get ra error message của page
    public String getTextboxErrorMessageByID(String errorMessageID) {
        waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_ERROR_MSG, errorMessageID);
        return getElementText(driver, BaseElementUI.DYNAMIC_TEXTBOX_ERROR_MSG, errorMessageID);
    }

    // Nhập vào 1 textbox bất kì tại bất kì page nào
    public void enterToTextboxByID(String textboxID, String valueToSend) {
        waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
        sendKeyToElement(driver,  BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, valueToSend, textboxID);
    }

    // Get ra attribute của textbox ở bất kì trang nào
    public String getTextboxAttributeByID(String textboxID) {
        waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
        return getElementAtrribute(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, "value", textboxID);
    }
}
