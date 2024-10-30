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

import java.util.ArrayList;
import java.util.List;

public class Level_13_Handle_DataTable extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;
    List<String> allValueUI = new ArrayList<String>();
    List<String> allValueDB = new ArrayList<String>();
    List<String> allValueAPI = new ArrayList<String>();

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

    //@Test
    public void TC_03_Displayed() {
        homePage.refreshCurrentPage(driver);

        // Verify for any row
        homePage.inputToColumnTextboxByName("Country", "Afghanistan");
        Assert.assertTrue(homePage.isRowValuesDisplayed("384187", "Afghanistan", "407124", "791312"));

        Assert.assertTrue(homePage.isRowValuesDisplayed("283821", "Algeria", "295140", "578961"));
    }

    //@Test
    public void TC_04_Icon_Button_Checkbox() {
        homePage.refreshCurrentPage(driver);

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

    //@Test
    public void TC_05_Get_All_Column_Values() {
        // UI
        allValueUI = homePage.getALlPageValuesByColumnName("Country");

        // API: Rest Assured/ Karate/ ...
        // allValueAPI = homePage.getALlPageValuesByColumnNameInAPI("Country");

        // DB: JTDS/ SQL/ ...
        // allValueDB = homePage.getALlPageValuesByColumnNameInDB("Country");

        Assert.assertEquals(allValueDB, allValueUI);

        Assert.assertEquals(allValueDB, allValueAPI);
    }

    @Test
    public void TC_06_Action_By_Index() {
        homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");

        // Nhập vào textbox tại cột Contact Person dòng thứ 2
        homePage.enterToTextboxByColumnNameAndRowIndex("Contact Person", "2", "Oliver Kahl");
        homePage.enterToTextboxByColumnNameAndRowIndex("Company", "1", "Bayer Munich");

        // Select dữ liệu tại cột Country dòng thứ 3
        homePage.selectDropdownByColumnNameAndRowIndex("Country", "3", "United Kingdom");
        homePage.selectDropdownByColumnNameAndRowIndex("Country", "1", "Japan");

        // homePage.selectCountryDropdownByRowIndex("3", "United Kingdom");

        // Click vào checkbox tại cột NPO? dòng thứ 1
        homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?", "2");
        homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?", "1");
        homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?", "3");
    }

    @AfterClass
    public void afterClass() {
        // closeBrowser();
    }
}
