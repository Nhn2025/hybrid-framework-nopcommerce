package com.nopcommerce.account;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
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

@Feature("User")
public class Level_18_AllureReport extends BaseTest {
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

    @Description("Register to application")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void User_01_Register_Success() {
        Assert.assertTrue(homePage.isRegisterLinkDisplayed());

        registerPage = homePage.clickToRegisterLink();

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");

        Assert.assertEquals(registerPage.getLastNameErrorMessageText(), "Last name is required");

        registerPage.enterToFirstNameTextbox(firstName);

        registerPage.enterToLastNameTextbox(lastName);

        registerPage.enterToEmailTextbox(emailAddress);

        registerPage.enterToPasswordTextbox(password);

        registerPage.enterToConfirmPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed.");
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}
