package com.jquery.table;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;
import pageObjects.user.*;

public class Level_13_Handle_DataTable extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);

        homePage = PageGeneratorManager.getHomePage(driver);
    }

    //@Test
    public void TC_01_Search() {
        // Search dữ liệu trong 1 table (trên Header)
        homePage.inputToColumnTextboxByName("Females", "283821");
        homePage.sleepInSecond(2);

        homePage.inputToColumnTextboxByName("Males", "295140");
        homePage.sleepInSecond(2);

        homePage.inputToColumnTextboxByName("Country", "Afghanistan");
        homePage.sleepInSecond(2);

        homePage.inputToColumnTextboxByName("Total", "791312");
        homePage.sleepInSecond(2);
    }

    //@Test
    public void TC_02_Paging() {
        // Click to any page
        homePage.clickToPageByNumber("10");
        homePage.sleepInSecond(2);
        Assert.assertTrue(homePage.isPageActiveByNumber("10"));

        // Click to any page
        homePage.clickToPageByNumber("4");
        homePage.sleepInSecond(2);
        Assert.assertTrue(homePage.isPageActiveByNumber("4"));
    }

    @Test
    public void TC_03_Displayed() {
        // Verify for any row
        homePage.inputToColumnTextboxByName("Country", "Afghanistan");
        Assert.assertTrue(homePage.isRowValuesDisplayed("384187", "Afghanistan", "407124", "791312"));

        Assert.assertTrue(homePage.isRowValuesDisplayed("283821", "Algeria", "295140", "578961"));
    }

    @Test
    public void TC_04_Icon_Button_Checkbox() {
        // Click vào bất kì 1 cái icon/ button/ checkbox của row nào đó
        // Tìm được 1 key là duy nhất của row đó
        homePage.clickToRowActionByCountryName("Afghanistan", "remove");
        homePage.clickToRowActionByCountryName("AFRICA", "remove");
        homePage.clickToRowActionByCountryName("Albania", "remove");
        homePage.clickToRowActionByCountryName("Algeria", "remove");
        homePage.refreshCurrentPage(driver);

        homePage.clickToRowActionByCountryName("Afghanistan", "edit");
        homePage.refreshCurrentPage(driver);

        homePage.clickToRowActionByCountryName("AFRICA", "edit");
        homePage.refreshCurrentPage(driver);
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}
