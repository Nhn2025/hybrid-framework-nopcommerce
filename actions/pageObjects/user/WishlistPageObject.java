package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class WishlistPageObject extends FooterPageObject{
    WebDriver driver;

    public WishlistPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
