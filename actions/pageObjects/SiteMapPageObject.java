package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class SiteMapPageObject extends BasePage{
    WebDriver driver;

    public SiteMapPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
