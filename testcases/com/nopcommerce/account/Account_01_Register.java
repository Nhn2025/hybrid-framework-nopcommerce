package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Account_01_Register {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void Register_01_Empty_Data() {

    }

    @Test
    public void Register_02_Invalid_Email() {

    }

    @Test
    public void Register_03_Invalid_Password() {

    }

    @Test
    public void Register_04_Incorrect_Confirm_Password() {

    }

    @Test
    public void Register_05_Success() {

    }

    @AfterClass
    public void afterClass() {

    }

}
