package com.jquery.upload;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.PageGeneratorManager;
import pageObjects.jquery.UploadPageObject;
import pageUIs.user.BasePageUI;

public class Level_14_Upload_File extends BaseTest {
    WebDriver driver;
    UploadPageObject uploadPage;

    String avatar = "avatar.jpg";
    String sua = "sua.jpg";
    String tho = "tho.jpg";

    String[] fileNames = {avatar, sua, tho};

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        uploadPage = PageGeneratorManager.getUploadPage(driver);
    }

    @Test
    public void TC_01_Upload_Single_File() {
        uploadPage.uploadMultipleFiles(driver, BasePageUI.UPLOAD_FILE_NAME_BLUE, sua);
        uploadPage.sleepInSecond(2);

        uploadPage.uploadMultipleFiles(driver, BasePageUI.UPLOAD_FILE_NAME_BLUE, tho);
        uploadPage.sleepInSecond(2);

        uploadPage.uploadMultipleFiles(driver, BasePageUI.UPLOAD_FILE_NAME_BLUE, avatar);
        uploadPage.sleepInSecond(2);

        Assert.assertTrue(uploadPage.isFileLoadedSuccess(sua));
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(tho));
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(avatar));

        uploadPage.clickStartButtonEachFile();

        Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(sua));
        Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(tho));
        Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(avatar));
    }

    @Test
    public void TC_02_Upload_Multiple_File() {
        uploadPage.refreshCurrentPage(driver);

        uploadPage.uploadMultipleFiles(driver, BasePageUI.UPLOAD_FILE_NAME_BLUE, fileNames);

        Assert.assertTrue(uploadPage.isFileLoadedSuccess(sua));
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(tho));
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(avatar));

        uploadPage.clickStartButtonEachFile();

        Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(sua));
        Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(tho));
        Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(avatar));
    }

    @Test
    public void TC_03_Upload_GoFile() {
        uploadPage.openPageUrl(driver, "https://gofile.io/?t=uploadFiles");

        Assert.assertTrue(uploadPage.isLoadingIconAtMainContentDisappear());

        uploadPage.clickUploadButtonAtMainContent();

        Assert.assertTrue(uploadPage.isLoadingIconAtMainUploadDisappear());

        uploadPage.uploadMultipleFiles(driver, BasePageUI.UPLOAD_FILE_NAME_GO_FILE, fileNames);

        Assert.assertTrue(uploadPage.isLoadingIconAtMainUploadDisappear());

        Assert.assertTrue(uploadPage.isMultipleProgressBarIconDisappear());

        Assert.assertTrue(uploadPage.isSuccessMessageDisplayed("Your files have been successfully uploaded"));

        uploadPage.clickToSuccessLink();

        Assert.assertTrue(uploadPage.isContentTableDisplayed());

        Assert.assertTrue(uploadPage.isDownloadButtonDisplayed(sua));
        Assert.assertTrue(uploadPage.isDownloadButtonDisplayed(tho));
        Assert.assertTrue(uploadPage.isDownloadButtonDisplayed(avatar));

        Assert.assertTrue(uploadPage.isPlayButtonDisplayed(sua));
        Assert.assertTrue(uploadPage.isPlayButtonDisplayed(tho));
        Assert.assertTrue(uploadPage.isPlayButtonDisplayed(avatar));
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
    // https://blueimp.github.io/jQuery-File-Upload/
}
