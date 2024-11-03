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

public class Level_16_Log extends BaseTest {
    private WebDriver driver;
    HomePageObject homePage;
    RegisterPageObject registerPage;
    private String emailAddress = getEmailRandom();
    private String adminURL, userURL;
    private String firstName, lastName, password;

    @Parameters({"browser", "adminUrl", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String adminURL, String userURL) {
        driver = getBrowserDriver(browserName,userURL);
        this.adminURL = adminURL;
        this.userURL = userURL;

        firstName = "John";
        lastName = "Kennedy";
        password = "123456";
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void User_01_Register_Success() {
        log.info("Register - Step 01: Verify Register link is displayed");
        Assert.assertTrue(homePage.isRegisterLinkDisplayed());

        log.info("Register - Step 02: Click to Register link");
        registerPage = homePage.clickToRegisterLink();

        log.info("Register - Step 03: Click to Register button");
        registerPage.clickToRegisterButton();

        log.info("Register - Step 04: Verify error message at FirstName textbox is 'First name is required.'");
        Assert.assertEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");

        log.info("Register - Step 05: Verify error message at LastName textbox is 'Last name is required'");
        Assert.assertEquals(registerPage.getLastNameErrorMessageText(), "Last name is required");

        log.info("Register - Step 06: Enter to First Name textbox with value is " + firstName);
        registerPage.enterToFirstNameTextbox(firstName);

        log.info("Register - Step 07: Enter to Last Name textbox with value is " + lastName);
        registerPage.enterToLastNameTextbox(lastName);

        log.info("Register - Step 08: Enter to Email Address textbox with value is " + emailAddress);
        registerPage.enterToEmailTextbox(emailAddress);

        log.info("Register - Step 09: Enter to Password textbox with value is " + password);
        registerPage.enterToPasswordTextbox(password);

        log.info("Register - Step 10: Enter to Confirm Password textbox with value is " + password);
        registerPage.enterToConfirmPasswordTextbox(password);

        log.info("Register - Step 11: Click to Register button");
        registerPage.clickToRegisterButton();

        log.info("Register - Step 12: Verify success message is displayed");
        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed.");
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}
