package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.jquery.HomePageUI;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToColumnTextboxByName(String columnName, String valueToSend) {
        waitForElementVisible(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, columnName);
        sendKeyToElement(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, valueToSend, columnName);
    }

    public void clickToPageByNumber(String pageNumber) {
        waitForElementClickable(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
        clickToElement(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
    }

    public boolean isPageActiveByNumber(String pageNumber) {
        waitForElementVisible(driver, HomePageUI.PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
        return isELementDisplayed(driver, HomePageUI.PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
    }

    public boolean isRowValuesDisplayed(String female, String country, String male, String total) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_ROW_VALUES, female, country, male, total);
        return isELementDisplayed(driver, HomePageUI.DYNAMIC_ROW_VALUES, female, country, male, total);
    }

    public void clickToRowActionByCountryName(String country, String rowAction) {
        waitForElementClickable(driver, HomePageUI.ROW_ACTION_BY_COUNTRY_NAME, country, rowAction);
        clickToElement(driver, HomePageUI.ROW_ACTION_BY_COUNTRY_NAME, country, rowAction);
    }
}
