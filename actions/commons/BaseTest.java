package commons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

public class BaseTest {

    protected WebDriver driver;
    protected final Logger log;

    public WebDriver getDriver() {
        return driver;
    }

    public BaseTest() {
        log = LogManager.getLogger(getClass());
    }

    protected WebDriver getBrowserDriver(String browserName) {

        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

        if (browser == BrowserList.FIREFOX)
            driver = new FirefoxDriver();
        else if (browser == BrowserList.CHROME)
            driver = new ChromeDriver();
        else if (browser == BrowserList.EDGE)
            driver = new EdgeDriver();
        else
            throw new RuntimeException("Browser name is not valid.");

        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.get("http://demo.nopcommerce/");
        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName, String url) {

        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

        if (browser == BrowserList.FIREFOX)
            driver = new FirefoxDriver();
        else if (browser == BrowserList.CHROME)
            driver = new ChromeDriver();
        else if (browser == BrowserList.EDGE)
            driver = new EdgeDriver();
        else
            throw new RuntimeException("Browser name is not valid.");

        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.get(url);
        return driver;
    }

    protected String getEmailRandom() {
        Random rand = new Random();
        return "john" + rand.nextInt(99999) + "@kennedy.us";
    }

    protected void closeBrowser() {
        // Tạo sao một biến cmd bằng null
        String cmd = null;
        try {
            String osName = GlobalConstants.OS_NAME.toLowerCase();
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("internetexplorer")) {
                browserDriverName = "IEDriverServer";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            // 1- Close browser
            if (driver != null) {
                // IE
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            // 2 - Quit driver (executable)
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {
            log.info("------------------------PASSED--------------------");
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            log.info("------------------------FAILED--------------------");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {
            log.info("------------------------PASSED--------------------");
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            log.info("------------------------FAILED--------------------");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            log.info("------------------------PASSED--------------------");
            Assert.assertEquals(actual, expected);
        } catch (Throwable e) {
            log.info("------------------------FAILED--------------------");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    @BeforeSuite
    public void deleteReportFolder() {
        deleteAllFileInFolder("htmlReportNG");
        deleteAllFileInFolder("allure-results");
        deleteAllFileInFolder("htmlAllure");
    }

    private void deleteAllFileInFolder(String folderName) {
        try {
            String pathFolderDownload = GlobalConstants.PROJECT_PATH + File.separator + folderName;
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            if (listOfFiles.length != 0) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
                        new File(listOfFiles[i].toString()).delete();
                    }
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

}
