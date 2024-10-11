package com.nopcommerce.account;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_BasePage_2_Static {
    private WebDriver driver;
    private BasePage basePage = BasePage.getBasePage();

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void Register_01_Empty_Data() {
        basePage.openPageUrl(driver, "http://demo.nopcommerce/");

        basePage.clickToElement(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
        Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
        Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
        Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
    }

    @Test
    public void Register_02_Invalid_Email() {
        basePage.openPageUrl(driver, "http://demo.nopcommerce/");

        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "John");
        basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Kennedy");
        basePage.sendKeyToElement(driver, "//input[@id='Email']", "john@kennedy.@us");
        basePage.sendKeyToElement(driver, "//input[@id='Password']", "123456");
        basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Please enter a valid email address.");
    }

    @Test
    public void Register_03_Invalid_Password() {
        basePage.openPageUrl(driver, "http://demo.nopcommerce/");

        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "John");
        basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Kennedy");
        basePage.sendKeyToElement(driver, "//input[@id='Email']", "john@kennedy.@us");
        basePage.sendKeyToElement(driver, "//input[@id='Password']", "123");
        basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123");

        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver, "//span[@class='field-validation-error']"), "Please enter a valid email address.");
    }

    @Test
    public void Register_04_Incorrect_Confirm_Password() {
        basePage.openPageUrl(driver, "http://demo.nopcommerce/");

        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "John");
        basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Kennedy");
        basePage.sendKeyToElement(driver, "//input[@id='Email']", "john@kennedy.@us");
        basePage.sendKeyToElement(driver, "//input[@id='Password']", "123456");
        basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "654321");

        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
    }

    @Test
    public void Register_05_Success() {
        basePage.openPageUrl(driver, "http://demo.nopcommerce/");

        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "John");
        basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Kennedy");
        basePage.sendKeyToElement(driver, "//input[@id='Email']", getEmailRandom());
        basePage.sendKeyToElement(driver, "//input[@id='Password']", "123456");
        basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
    }

    @AfterClass
    public void afterClass() {

    }

    public String getEmailRandom() {
        Random rand = new Random();
        return "john" + rand.nextInt(99999) + "@kennedy.us";
    }

}
