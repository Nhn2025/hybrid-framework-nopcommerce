package pageObjects;
import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.OrderPageUI;

public class OrderPageObject extends BasePage{
    WebDriver driver;

    public OrderPageObject(WebDriver driver) {
        this.driver = driver;
    }

}

