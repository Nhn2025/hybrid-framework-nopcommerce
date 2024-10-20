package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class SiteMapPageObject extends FooterPageObject{
    WebDriver driver;

    public SiteMapPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
