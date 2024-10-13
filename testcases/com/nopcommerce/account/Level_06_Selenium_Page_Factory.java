package com.nopcommerce.account;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.factory.CustomerPageObject;
import pageObject.factory.HomePageObject;
import pageObject.factory.LoginPageObject;
import pageObject.factory.RegisterPageObject;


public class Level_06_Selenium_Page_Factory extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerPageObject customerPage;
    private String emailAddress = getEmailRandom();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
    }

    @Test
    public void User_01_Register_Empty_Data() {
        homePage = new HomePageObject(driver);

        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");
        Assert.assertEquals(registerPage.getLastNameErrorMessageText(), "Last name is required.");
        Assert.assertEquals(registerPage.getEmailErrorMessageText(), "Email is required.");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMessageText(), "Password is required.");
    }

    @Test
    public void User_02_Register_Invalid_Email() {

        registerPage.clickToNopCommerceLogo();

        homePage = new HomePageObject(driver);

        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);

        registerPage.enterToFirstNameTextbox("John");
        registerPage.enterToLastNameTextbox("Kennedy");
        registerPage.enterToEmailTextbox("john@kennedy.@us");
        registerPage.enterToPasswordTextbox("123456");
        registerPage.enterToConfirmPasswordTextbox("123456");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getEmailErrorMessageText(), "Please enter a valid email address.");
    }

    @Test
    public void User_03_Register_Invalid_Password() {
        registerPage.clickToNopCommerceLogo();

        homePage = new HomePageObject(driver);

        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);

        registerPage.enterToFirstNameTextbox("John");
        registerPage.enterToLastNameTextbox("Kennedy");
        registerPage.enterToEmailTextbox("john@kennedy.us");
        registerPage.enterToPasswordTextbox("123");
        registerPage.enterToConfirmPasswordTextbox("123");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getPasswordErrorMessageText(), "<p>must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");
    }

    @Test
    public void User_04_Register_Incorrect_Confirm_Password() {
        registerPage.clickToNopCommerceLogo();

        homePage = new HomePageObject(driver);

        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);

        registerPage.enterToFirstNameTextbox("John");
        registerPage.enterToLastNameTextbox("Kennedy");
        registerPage.enterToEmailTextbox("john@kennedy.us");
        registerPage.enterToPasswordTextbox("123456");
        registerPage.enterToConfirmPasswordTextbox("654321");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getConfirmPasswordErrorMessageText(), "The password and confirmation password do not match.");
    }

    @Test
    public void User_05_Register_Success() {
        registerPage.clickToNopCommerceLogo();

        homePage = new HomePageObject(driver);

        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);

        registerPage.enterToFirstNameTextbox("John");
        registerPage.enterToLastNameTextbox("Kennedy");
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox("123456");
        registerPage.enterToConfirmPasswordTextbox("123456");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");
    }

    @Test
    public void User_06_Login_Success() {
        registerPage.clickToLogOutLink();

        homePage = new HomePageObject(driver);

        homePage.clickToLoginLink();

        loginPage = new LoginPageObject(driver);

        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox("123456");

        loginPage.clickLoginButton();

        homePage = new HomePageObject(driver);

        homePage.clickToMyAccountLink();

        customerPage = new CustomerPageObject(driver);

        Assert.assertEquals(customerPage.getFirstNameTextboxAttributeValue(), "John");
        Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(), "Kennedy");
        Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(), emailAddress);
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}
