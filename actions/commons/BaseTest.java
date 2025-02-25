package commons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriverLogLevel;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.*;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.*;

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
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid.");
        }

        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.get(url);
        return driver;
    }

    // Automation Info Bar
    protected WebDriver getBrowserDriverInfoBar(String browserName, String url) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("useAutomationExtension", false);
                chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                driver = new ChromeDriver(chromeOptions);
                break;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setExperimentalOption("useAutomationExtension", false);
                edgeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new RuntimeException("Browser name is not valid.");
        }

        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.get(url);
        return driver;
    }

    // Location popup
    protected WebDriver getBrowserDriverLocationPopup(String browserName, String url) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addPreference("geo.enabled", false);
                firefoxOptions.addPreference("geo.provider.user_corelocation", false);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-geolocation");
                driver = new ChromeDriver(chromeOptions);
                break;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-geolocation");
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new RuntimeException("Browser name is not valid.");
        }

        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.get(url);
        return driver;
    }

    // Disable Save address (Chrome/ Edge)
    protected WebDriver getBrowserDriverDisableSaveAddress(String browserName, String url) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addPreference("dom.webnotifications.enabled", false);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case CHROME:
                Map<String, Object> cprefs = new HashMap<String, Object>();
                cprefs.put("profile.default_content_setting_values.notifications", 2);
                cprefs.put("credentials_enable_service", false);
                cprefs.put("profile.password_manager_enabled", false);
                cprefs.put("autofill.profile_enabled", false);

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("prefs", cprefs);
                driver = new ChromeDriver(chromeOptions);
                break;
            case EDGE:
                Map<String, Object> eprefs = new HashMap<String, Object>();
                eprefs.put("profile.default_content_setting_values.notifications", 2);
                eprefs.put("credentials_enable_service", false);
                eprefs.put("profile.password_manager_enabled", false);
                eprefs.put("autofill.profile_enabled", false);

                EdgeOptions edgOptions = new EdgeOptions();
                edgOptions.setExperimentalOption("prefs", eprefs);
                driver = new EdgeDriver(edgOptions);
                break;
            default:
                throw new RuntimeException("Browser name is not valid.");
        }

        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.get(url);
        return driver;
    }

    // Disable notifications
    protected WebDriver getBrowserDriverDisableNotifications(String browserName, String url) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addPreference("dom.webnotifications.enabled", false);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications");
                driver = new ChromeDriver(chromeOptions);
                break;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-notifications");
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new RuntimeException("Browser name is not valid.");
        }

        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.get(url);
        return driver;
    }

    // Localization
    protected WebDriver getBrowserDriverLocalization(String browserName, String url) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addPreference("intl.accept_languages", "vi-vn, vi");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--lang=vi");
                driver = new ChromeDriver(chromeOptions);
                break;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--lang=vi");
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new RuntimeException("Browser name is not valid.");
        }

        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.get(url);
        return driver;
    }

    // Log to Level
    protected WebDriver getBrowserDriverLogLevel(String browserName, String url) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case FIREFOX:
                System.setProperty(GeckoDriverService.GECKO_DRIVER_LOG_PROPERTY, GlobalConstants.BROWSER_LOG_PATH + "FirefoxPropertyLog.log");
                FirefoxDriverService fService = new GeckoDriverService.Builder().withLogLevel(FirefoxDriverLogLevel.DEBUG).build();
                driver = new FirefoxDriver(fService);
                break;
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();

                System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, GlobalConstants.BROWSER_LOG_PATH + "ChromePropertyLog.log");
                ChromeDriverService cService = new ChromeDriverService.Builder().withLogLevel(ChromiumDriverLogLevel.DEBUG).build();
                driver = new ChromeDriver(cService);
                break;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();

                System.setProperty(EdgeDriverService.EDGE_DRIVER_LOG_PROPERTY, GlobalConstants.BROWSER_LOG_PATH + "EdgePropertyLog.log");
                EdgeDriverService eService = new EdgeDriverService.Builder().withLoglevel(ChromiumDriverLogLevel.DEBUG).build();
                driver = new EdgeDriver(eService);
                break;
            default:
                throw new RuntimeException("Browser name is not valid.");
        }

        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.get(url);
        return driver;
    }

    // Log to Console
    protected WebDriver getBrowserDriverLogConsole(String browserName, String url) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case FIREFOX:
                FirefoxDriverService fService = new GeckoDriverService.Builder().withLogOutput(System.out).build();
                driver = new FirefoxDriver(fService);
                break;
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();

                ChromeDriverService cService = new ChromeDriverService.Builder().withLogOutput(System.out).build();
                driver = new ChromeDriver(cService);
                break;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();

                EdgeDriverService eService = new EdgeDriverService.Builder().withLogOutput(System.out).build();
                driver = new EdgeDriver(eService);
                break;
            default:
                throw new RuntimeException("Browser name is not valid.");
        }

        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.get(url);
        return driver;
    }

    // Log to File
    protected WebDriver getBrowserDriverLogFile(String browserName, String url) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case FIREFOX:
                FirefoxDriverService fService = new GeckoDriverService.Builder().withLogFile(
                        new File(GlobalConstants.BROWSER_LOG_PATH + "FirefoxLog.log")).build();
                driver = new FirefoxDriver(fService);
                break;
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();

                ChromeDriverService cService = new ChromeDriverService.Builder().withLogFile(
                        new File(GlobalConstants.BROWSER_LOG_PATH + "ChromeLog.log")).build();
                driver = new ChromeDriver(cService);
                break;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();

                EdgeDriverService eService = new EdgeDriverService.Builder().withLogFile(
                        new File(GlobalConstants.BROWSER_LOG_PATH + "EdgeLog.log")).build();
                driver = new EdgeDriver(eService);
                break;
            default:
                throw new RuntimeException("Browser name is not valid.");
        }

        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.get(url);
        return driver;
    }

    // Extension & HeadLess
    protected WebDriver getBrowserDriverExtensionHeadLess(String browserName, String url) {

        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        Path path = null;
        File extensionFilePath = null;

        switch (browserList) {
            case FIREFOX:
                driver = new FirefoxDriver();
                Path xpiPath = Paths.get(GlobalConstants.BROWSER_EXTENSION_PATH + "Wappalyzer.xpi");
                FirefoxDriver ffDriver = (FirefoxDriver) driver;
                ffDriver.installExtension(xpiPath);
                driver = ffDriver;
                break;
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                path = Paths.get(GlobalConstants.BROWSER_EXTENSION_PATH + "Wappalyzer.crx");
                extensionFilePath = new File(path.toUri());
                chromeOptions.addExtensions(extensionFilePath);
                driver = new ChromeDriver(chromeOptions);
                break;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                path = Paths.get(GlobalConstants.BROWSER_EXTENSION_PATH + "Wappalyzer.crx");
                extensionFilePath = new File(path.toUri());
                edgeOptions.addExtensions(extensionFilePath);
                driver = new EdgeDriver(edgeOptions);
                break;
            case HFIREFOX:
                FirefoxOptions hfFirefoxOptions = new FirefoxOptions();
                hfFirefoxOptions.addArguments("-headless");
                hfFirefoxOptions.addArguments("window-size=1920x1080");
                driver = new FirefoxDriver(hfFirefoxOptions);
                break;
            case HCHROME:
                ChromeOptions hChromeOptions = new ChromeOptions();
                hChromeOptions.addArguments("-headless");
                hChromeOptions.addArguments("window-size=1920x1080");
                driver = new ChromeDriver(hChromeOptions);
                break;
            case HEDGE:
                EdgeOptions hEdgeOptions = new EdgeOptions();
                hEdgeOptions.addArguments("-headless");
                hEdgeOptions.addArguments("window-size=1920x1080");
                driver = new EdgeDriver(hEdgeOptions);
                break;
            default:
                throw new RuntimeException("Browser name is not valid.");
        }

        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.get(url);
        return driver;
    }

    protected WebDriver getBrowserDriverIf(String browserName, String url) {

        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
        Path path = null;
        File extensionFilePath = null;

        if (browser == BrowserList.FIREFOX) {
            driver = new FirefoxDriver();
            Path xpiPath = Paths.get(GlobalConstants.BROWSER_EXTENSION_PATH + "Wappalyzer.xpi");
            FirefoxDriver ffDriver = (FirefoxDriver) driver;
            ffDriver.installExtension(xpiPath);
            driver = ffDriver;
        }
        else if (browser == BrowserList.CHROME) {
            ChromeOptions chromeOptions = new ChromeOptions();
            path = Paths.get(GlobalConstants.BROWSER_EXTENSION_PATH + "Wappalyzer.crx");
            extensionFilePath = new File(path.toUri());
            chromeOptions.addExtensions(extensionFilePath);
            driver = new ChromeDriver(chromeOptions);
        }
        else if (browser == BrowserList.EDGE) {
            EdgeOptions edgeOptions = new EdgeOptions();
            path = Paths.get(GlobalConstants.BROWSER_EXTENSION_PATH + "Wappalyzer.crx");
            extensionFilePath = new File(path.toUri());
            edgeOptions.addExtensions(extensionFilePath);
            driver = new EdgeDriver(edgeOptions);
        }
        else if (browser == BrowserList.HFIREFOX) {
            FirefoxOptions hFirefoxOptions = new FirefoxOptions();
            hFirefoxOptions.addArguments("-headless");
            hFirefoxOptions.addArguments("window-size=1920x1080");
            driver = new FirefoxDriver(hFirefoxOptions);
        } else if (browser == BrowserList.HCHROME) {
            ChromeOptions hChromeOptions = new ChromeOptions();
            hChromeOptions.addArguments("-headless");
            hChromeOptions.addArguments("window-size=1920x1080");
            driver = new ChromeDriver(hChromeOptions);
        } else if (browser == BrowserList.HEDGE) {
            EdgeOptions hEdgeOptions = new EdgeOptions();
            hEdgeOptions.addArguments("-headless");
            hEdgeOptions.addArguments("window-size=1920x1080");
            driver = new EdgeDriver(hEdgeOptions);
        }
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
