package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jquery.UploadPageUI;

import java.util.List;

public class UploadPageObject extends BasePage {
    WebDriver driver;

    public UploadPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isFileLoadedSuccess(String fileName) {
        waitForElementVisible(driver, UploadPageUI.FILE_LOADED_BY_NAME, fileName);
        return isELementDisplayed(driver, UploadPageUI.FILE_LOADED_BY_NAME, fileName);
    }

    public void clickStartButtonEachFile() {
        List<WebElement> startButtons = getListWebElement(driver, UploadPageUI.MULTIPLE_START_BUTTON);
        for (WebElement startButton : startButtons) {
            waitForElementClickable(driver, startButton);
            clickToElement(driver, startButton);
            sleepInSecond(2);
        }
    }

    public boolean isFileUpLoadedSuccess(String fileName) {
        waitForElementVisible(driver, UploadPageUI.FILE_UPLOAD_BY_NAME, fileName);
        return isELementDisplayed(driver, UploadPageUI.FILE_UPLOAD_BY_NAME, fileName);
    }

    public boolean isLoadingIconAtMainContentDisappear() {
        return waitForElementInvisible(driver, UploadPageUI.SPIN_BORDER_ICON_AT_MAIN_CONTENT);
    }

    public boolean isLoadingIconAtMainUploadDisappear() {
        return waitForElementInvisible(driver, UploadPageUI.SPIN_BORDER_ICON_AT_MAIN_UPLOAD);
    }

    public boolean isMultipleProgressBarIconDisappear() {
        return waitForListElementInvisible(driver, UploadPageUI.MULTIPLE_PROGRESS_BAR_ICON);
    }

    public boolean isSuccessMessageDisplayed(String successMessage) {
        waitForElementVisible(driver, UploadPageUI.UPLOADED_SUCCESS_MESSAGE, successMessage);
        return isELementDisplayed(driver, UploadPageUI.UPLOADED_SUCCESS_MESSAGE, successMessage);
    }

    public void clickToSuccessLink() {
        waitForElementClickable(driver, UploadPageUI.UPLOADED_SUCCESS_LINK);
        clickToElement(driver, UploadPageUI.UPLOADED_SUCCESS_LINK);
    }

    public boolean isContentTableDisplayed() {
        waitForElementVisible(driver, UploadPageUI.CONTENT_TABLE);
        return isELementDisplayed(driver, UploadPageUI.CONTENT_TABLE);
    }

    public boolean isDownloadButtonDisplayed(String fileName) {
        waitForElementVisible(driver, UploadPageUI.DOWNLOAD_BUTTON_BY_FILE_NAME, fileName);
        return isELementDisplayed(driver, UploadPageUI.DOWNLOAD_BUTTON_BY_FILE_NAME, fileName);
    }

    public boolean isPlayButtonDisplayed(String fileName) {
        waitForElementVisible(driver, UploadPageUI.PLAY_BUTTON_BY_FILE_NAME, fileName);
        return isELementDisplayed(driver, UploadPageUI.PLAY_BUTTON_BY_FILE_NAME, fileName);
    }

    public void clickUploadButtonAtMainContent() {
        waitForElementClickable(driver, UploadPageUI.UPLOAD_BUTTON);
        clickToElement(driver, UploadPageUI.UPLOAD_BUTTON);
    }
}
