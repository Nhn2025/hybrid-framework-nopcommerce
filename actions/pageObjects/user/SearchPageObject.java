package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class SearchPageObject extends FooterPageObject{
    WebDriver driver;

    public SearchPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
