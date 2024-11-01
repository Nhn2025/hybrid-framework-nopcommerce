package com.nopcommerce.account;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.*;

public class Level_15_Assert_Verify extends BaseTest {
    private WebDriver driver;
    HomePageObject homePage;
    RegisterPageObject registerPage;
    private String emailAddress = getEmailRandom();
    private String adminURL, userURL;

    @Parameters({"browser", "adminUrl", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String adminURL, String userURL) {
        driver = getBrowserDriver(browserName,userURL);
        this.adminURL = adminURL;
        this.userURL = userURL;
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void User_01_Register_Success() {
        // Verify Register Link Undisplayed
        verifyFalse(homePage.isRegisterLinkDisplayed());

        registerPage = homePage.clickToRegisterLink();

        registerPage.clickToRegisterButton();

        // Verify error message at FirstName text -> PASSED
        verifyEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");

        // Verify error message at LastName text -> FAILED
        verifyEquals(registerPage.getLastNameErrorMessageText(), "Last name is required");

        registerPage.enterToFirstNameTextbox("John");
        registerPage.enterToLastNameTextbox("Kennedy");
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox("123456");
        registerPage.enterToConfirmPasswordTextbox("123456");

        registerPage.clickToRegisterButton();

        // Verify success message -> FAILED
        verifyEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed.");
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}
