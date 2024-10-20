package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPageObject extends FooterPageObject{
    WebDriver driver;

    public ShoppingCartPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
