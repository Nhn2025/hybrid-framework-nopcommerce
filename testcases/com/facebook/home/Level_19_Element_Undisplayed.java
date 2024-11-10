package com.facebook.home;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.facebook.HomePageObject;
import pageObjects.facebook.PageGeneratorManager;

public class Level_19_Element_Undisplayed extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String urlValue) {
        driver = getBrowserDriver(browserName, urlValue);

        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void Home_01_Element_Displayed() {
        homePage.clickToCreateNewAccount();

        verifyTrue(homePage.isFirstNameTextboxDisplayed());
        verifyTrue(homePage.isSurNameTextboxDisplayed());
        verifyTrue(homePage.isEmailTextboxDisplayed());
        verifyTrue(homePage.isPasswordTextboxDisplayed());

        homePage.enterToEmailTextbox("auttomationfc@gmail.com");

        // Đổi UI không còn xuất hiện ConfirmEmailText
        log.info("Verify Confirm Email textbox is displayed");
        //verifyTrue(homePage.isConfirmEmailTextboxDisplayed());
    }

    @Test
    public void Home_02_Element_Undisplayed_In_HTML() {
        homePage.enterToEmailTextbox("");
        homePage.sleepInSecond(2);

        // Sau khi xóa dữ liệu Email Textbox đi - thì Confirm Email textbox không hiển thị trên UI
        // Nhưng vẫn có trong HTML
        log.info("Verify Confirm Email textbox is not displayed");
        verifyFalse(homePage.isConfirmEmailTextboxDisplayed());
    }

    //@Test
    public void Home_03_Element_Undisplayed_Not_In_HTML() {
        // Đổi giao diện không còn nút Close
        homePage.clickToCloseSignUpPopup();
        //driver.get("https://www.facebook.com/");

        log.info("Verify First Name textbox is not displayed");
        verifyFalse(homePage.isFirstNameTextboxDisplayed());

        log.info("Verify Sur Name textbox is not displayed");
        verifyFalse(homePage.isSurNameTextboxDisplayed());

        log.info("Verify Email textbox is not displayed");
        verifyFalse(homePage.isEmailTextboxDisplayed());

        log.info("Verify Password textbox is not displayed");
        verifyFalse(homePage.isPasswordTextboxDisplayed());
    }

    @Test
    public void Home_03_Element_Undisplayed_Not_In_HTML_02() {
        // Đổi giao diện không còn nút Close
        homePage.clickToCloseSignUpPopup();
        //driver.get("https://www.facebook.com/");

        log.info("Verify First Name textbox is not displayed");
        verifyTrue(homePage.isFirstNameTextboxUndisplayed());

        log.info("Verify Sur Name textbox is not displayed");
        verifyTrue(homePage.isSurNameTextboxUndisplayed());

        log.info("Verify Email textbox is not displayed");
        verifyTrue(homePage.isEmailTextboxUndisplayed());

        log.info("Verify Password textbox is not displayed");
        verifyTrue(homePage.isPasswordTextboxUndisplayed());
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}
