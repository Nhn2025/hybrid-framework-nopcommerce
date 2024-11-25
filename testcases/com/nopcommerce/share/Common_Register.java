package com.nopcommerce.share;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;

import java.util.Set;

public class Common_Register extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;

    public static String emailAddress, firstName, lastName, password;

    @Parameters("browser")
    @BeforeTest
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);

        password = "123456";
        firstName = "John";
        lastName = "Kennedy";
        emailAddress = getEmailRandom();

        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");

        closeBrowser();
    }

}
