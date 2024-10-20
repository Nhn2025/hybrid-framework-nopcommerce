package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class WishlistPageObject extends BasePage{
    WebDriver driver;

    public WishlistPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
