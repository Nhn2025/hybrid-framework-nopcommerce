package com.nopcommerce.account;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.RegisterPageObject;

public class Level_04_Multiple_Browser extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private CustomerPageObject customerPage;
    private String emailAddress = getEmailRandom();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
    }

    @Test
    public void User_01_Register_Empty_Data() {
        // Mở 1 Url ra nó ở page nào -> khởi tạo page đó lên
        // Từ 1 page này chuyển qua page kia -> khởi tạo page đó lên
        homePage = new HomePageObject(driver);

        homePage.clickToRegisterLink();

        // Từ Home Page click vào Register Link nó sẽ mở ra Register Page
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

        // Đang từ Register Page click vào Logo thì nó mở ra trang Home lại
        homePage = new HomePageObject(driver);

        homePage.clickToRegisterLink();

        // Từ Home Page click vào Register Link nó sẽ mở ra Register Page
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

        // Đang từ Register Page click vào Logo thì nó mở ra trang Home lại
        homePage = new HomePageObject(driver);

        homePage.clickToRegisterLink();

        // Từ Home Page click vào Register Link nó sẽ mở ra Register Page
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

        // Đang từ Register Page click vào Logo thì nó mở ra trang Home lại
        homePage = new HomePageObject(driver);

        homePage.clickToRegisterLink();

        // Từ Home Page click vào Register Link nó sẽ mở ra Register Page
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

        // Đang từ Register Page click vào Logo thì nó mở ra trang Home lại
        homePage = new HomePageObject(driver);

        homePage.clickToRegisterLink();

        // Từ Home Page click vào Register Link nó sẽ mở ra Register Page
        registerPage = new RegisterPageObject(driver);

        registerPage.enterToFirstNameTextbox("John");
        registerPage.enterToLastNameTextbox("Kennedy");
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox("123456");
        registerPage.enterToConfirmPasswordTextbox("123456");

        registerPage.clickToRegisterButton();

        // Chạy qua rồi lấy text để verify vs 1 text mà mình mong đợi
        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");
    }

    @Test
    public void User_06_Login_Success() {
        registerPage.clickToLogoutLink();

        // Đang từ Register Page click vào Logo thì nó mở ra trang Home lại
        homePage = new HomePageObject(driver);

        // CLick Login link
        homePage.clickToLoginLink();

        // Từ trang Home click vào Login Link nó sẽ mở ra trang Login
        loginPage = new UserLoginPageObject(driver);

        // Input Email/ Password
        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox("123456");

        // CLick Login button
        loginPage.clickLoginButton();

        // Từ trang login nhập data hợp lệ và click Login button thì nó sẽ quay lại trang Home (login thành công)
        homePage = new HomePageObject(driver);

        // Click My Account link
        homePage.clickToMyAccountLink();

        // Từ trang Home click My Account nó sẽ mở ra trang Customer Info
        customerPage = new CustomerPageObject(driver);

        // Verify
        Assert.assertEquals(customerPage.getFirstNameTextboxAttributeValue(), "John");
        Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(), "Kennedy");
        Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(), emailAddress);
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}
