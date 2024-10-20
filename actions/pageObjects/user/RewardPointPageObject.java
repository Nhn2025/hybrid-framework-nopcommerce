package pageObjects.user;
import org.openqa.selenium.WebDriver;

public class RewardPointPageObject extends MyAccountSideBarPageObject{
    WebDriver driver;
    private FooterPageObject footer;

    public RewardPointPageObject(WebDriver driver) {
        super(driver);
        this.footer = new FooterPageObject(driver);
        this.driver = driver;
    }

    public FooterPageObject getFooter() {
        return footer;
    }
}

