package com.nopcommerce.share;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.UserLoginPageObject;

public class Product_Detail extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private CustomerPageObject customerPage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);

        loginPage = homePage.clickToLoginLink();

        loginPage.enterToEmailTextbox(Common_Register.emailAddress);
        loginPage.enterToPasswordTextbox(Common_Register.password);

        homePage = loginPage.clickLoginButton();

        customerPage = homePage.clickToMyAccountLink();

        Assert.assertEquals(customerPage.getFirstNameTextboxAttributeValue(), Common_Register.firstName);
        Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(), Common_Register.lastName);
        Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(), Common_Register.emailAddress);
    }

    @Test
    public void Product_01_New_Product() {

    }
    @Test
    public void Product_02_View_Product() {

    }
    @Test
    public void Product_03_Edit_Product() {

    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}
