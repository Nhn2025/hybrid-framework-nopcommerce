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

public class Level_12_Dynamic_Locator_Rest_Param extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private CustomerPageObject customerPage;
    private OrderPageObject orderPage;
    private RewardPointPageObject rewardPointPage;
    private AddressPageObject addressPage;
    private SiteMapPageObject siteMapPage;
    private ShoppingCartPageObject shoppingCartPage;
    private SearchPageObject searchPage;
    private WishlistPageObject wishlistPage;
    private String emailAddress = getEmailRandom();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void User_01_Register_Success() {
        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextbox("John");
        registerPage.enterToLastNameTextbox("Kennedy");
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox("123456");
        registerPage.enterToConfirmPasswordTextbox("123456");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");
    }

    @Test
    public void User_02_Login_Success() {
        homePage = registerPage.clickToLogoutLink();

        loginPage = homePage.clickToLoginLink();

        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox("123456");

        homePage = loginPage.clickLoginButton();

        customerPage = homePage.clickToMyAccountLink();
        
        Assert.assertEquals(customerPage.getFirstNameTextboxAttributeValue(), "John");
        Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(), "Kennedy");
        Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(), emailAddress);
    }

    @Test
    public void User_03_Page_Navigation() {
        // Customer Page -> Address Page
        addressPage = customerPage.openAddressPage();

        // Address Page -> Order Page
        orderPage = addressPage.openOrderPage();

        // Order Page -> Customer Page
        customerPage = orderPage.openCustomerPage();

        // Customer Page -> Order Page
        orderPage = customerPage.openOrderPage();

        // Order Page -> Address Page
        addressPage = orderPage.openAddressPage();

        // Address Page -> Reward Point Page
        rewardPointPage = addressPage.openRewardPointPage();

        // Reward Point Page -> Customer Page
        customerPage = rewardPointPage.openCustomerPage();

        // Customer Page -> Reward Point Page
        rewardPointPage = customerPage.openRewardPointPage();
    }

    @Test
    public void User_04_Page_Navagation() {
        // Customer Page -> Address Page
        addressPage = (AddressPageObject) customerPage.openDynamicSidebarPage("Addresses");

        // Address Page -> Order Page
        orderPage = (OrderPageObject) addressPage.openDynamicSidebarPage("Orders");

        // Order Page -> Customer Page
        customerPage = (CustomerPageObject) orderPage.openDynamicSidebarPage("Customer info");

        // Customer Page -> Order Page
        orderPage = (OrderPageObject) customerPage.openDynamicSidebarPage("Orders");

        // Order Page -> Address Page
        addressPage = (AddressPageObject) orderPage.openDynamicSidebarPage("Addresses");

        // Address Page -> Reward Point Page
        rewardPointPage = (RewardPointPageObject) addressPage.openDynamicSidebarPage("Reward points");

        // Reward Point Page -> Customer Page
        customerPage = (CustomerPageObject) rewardPointPage.openDynamicSidebarPage("Customer info");

        // Customer Page -> Reward Point Page
        rewardPointPage = (RewardPointPageObject) customerPage.openDynamicSidebarPage("Reward points");
    }

    @Test
    public void User_05_Page_Navagation() {
        // Reward Point Page -> Customer Page
        rewardPointPage.openDynamicSidebarPage("Customer info");
        customerPage = PageGeneratorManager.getCustomerPage(driver);

        // Customer Page -> Reward Point Page
        customerPage.openDynamicSidebarPage("Reward points");
        rewardPointPage = PageGeneratorManager.getRewardPointPage(driver);

        rewardPointPage.openDynamicSidebarPageByName("Orders");
        orderPage = PageGeneratorManager.getOrderPage(driver);
    }

    @Test
    public void User_06_Page_Navagation_Exercise() {
        // Reward Point Page -> Site Map Page
        rewardPointPage.getFooter().openDynamicFooterPageByName("Sitemap");
        siteMapPage = PageGeneratorManager.getSiteMapPage(driver);

        // Site Map Page -> Shopping Cart Page
        siteMapPage.openDynamicFooterPageByName("Shopping cart");
        shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);

        // Shopping Cart Page -> Search Page
        shoppingCartPage.openDynamicFooterPageByName("Search");
        searchPage = PageGeneratorManager.getSearchPage(driver);

        // Search Page -> Wishlist Page
        searchPage.openDynamicFooterPageByName("Wishlist");
        wishlistPage = PageGeneratorManager.getWishlistPage(driver);
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}
