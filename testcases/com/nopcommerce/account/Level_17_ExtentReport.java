package com.nopcommerce.account;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;
import reportConfig.ExtentManager;

import java.lang.reflect.Method;
import java.util.Locale;

public class Level_17_ExtentReport extends BaseTest {
    private WebDriver driver;
    HomePageObject homePage;
    RegisterPageObject registerPage;
    private String emailAddress = getEmailRandom();
    private String adminURL, userURL;
    private String firstName, lastName, password;
    String browserName;

    @Parameters({"browser", "adminUrl", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String adminURL, String userURL) {
        driver = getBrowserDriver(browserName,userURL);
        this.adminURL = adminURL;
        this.userURL = userURL;

        this.browserName = browserName.toUpperCase();

        firstName = "John";
        lastName = "Kennedy";
        password = "123456";
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void User_01_Register_Success(Method method) {
        ExtentManager.startTest(method.getName() + " - Run on " + browserName,"User_01_Register");
        ExtentManager.getTest().log(Status.INFO, "User_01_Register - Step 01: Verify Register link is displayed");
        Assert.assertTrue(homePage.isRegisterLinkDisplayed());

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - Step 02: Click to Register link");
        registerPage = homePage.clickToRegisterLink();

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - Step 03: Click to Register button");
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - Step 04: Verify error message at FirstName textbox is 'First name is required.'");
        Assert.assertEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - Step 05: Verify error message at LastName textbox is 'Last name is required'");
        Assert.assertEquals(registerPage.getLastNameErrorMessageText(), "Last name is required");

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - Step 06: Enter to First Name textbox with value is " + firstName);
        registerPage.enterToFirstNameTextbox(firstName);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - Step 07: Enter to Last Name textbox with value is " + lastName);
        registerPage.enterToLastNameTextbox(lastName);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - Step 08: Enter to Email Address textbox with value is " + emailAddress);
        registerPage.enterToEmailTextbox(emailAddress);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - Step 09: Enter to Password textbox with value is " + password);
        registerPage.enterToPasswordTextbox(password);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - Step 10: Enter to Confirm Password textbox with value is " + password);
        registerPage.enterToConfirmPasswordTextbox(password);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - Step 11: Click to Register button");
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - Step 12: Verify success message is displayed");
        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed.");
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}
