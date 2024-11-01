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

import java.time.Duration;
import java.util.Random;

public class BaseTest {

    protected final Logger log;

    public BaseTest() {
        log = LogManager.getLogger(getClass());
    }

    private WebDriver driver;

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
        if (driver == null)
            System.out.println("Browser is closed.");
        else
            driver.quit();
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
}
