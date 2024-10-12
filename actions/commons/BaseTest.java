package commons;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Random;

public class BaseTest {
    private WebDriver driver;

    protected WebDriver getBrowserDriver(String browserName) {

        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

        if (browser == BrowserList.FIREFOX)
            driver = new FirefoxDriver();
        else if (browser == BrowserList.CHROME)
            driver = new ChromeDriver();
        else if (browser == BrowserList.EDEGE)
            driver = new EdgeDriver();
        else
            throw new RuntimeException("Browser name is not valid.");

        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://demo.nopcommerce/");
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
}
