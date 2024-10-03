package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class BasePage {
    // Toàn cục: phạm vi là ở Class
    WebDriver driver;

    // 1 - Access Modifier: public/ protected/ private/ default

    // 2 - Kiểu dữ liệu của hàm (Data type): void/ int/ String/ boolean/ WebElement/ List<WebElements/..
    // Nó sẽ liên quan đến cái chức năng mình viết trong thân hàm

    // 3 - Tên hàm: Đặt tên có nghĩa theo chức năng đang cần viết
    // Convention tuân theo chuẩn của từng ngôn ngữ lập trình (Java)

    // 4 - Có tham số hay ko (tùy vào chức năng cần viết)

    // 5 - Kiểu dữ liệu trả về cho hàm
    // Hoàn thành xong phần thân của hàm
    // Nếu như có return dữ liệu thì sẽ khớp vs kiểu dữ liệu ở số 2
    // Nếu như có return thì nó là cái step cuối cùng

    /* Web Browser */
    public void openPageUrl(WebDriver driver, String pageUrl) {
        driver.get(pageUrl);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getCurentPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public Alert waitForAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
    }

    public void acceptToAlert(WebDriver driver) {
        // Vừa wait vừa accept
        // driver.switchTo().alert().accept(); =
        waitForAlertPresence(driver).accept();
    }

    public void cancelToAlert(WebDriver driver) {
        waitForAlertPresence(driver).dismiss();
    }

    public void getTextInAlert(WebDriver driver) {
        waitForAlertPresence(driver).getText();
    }

    public void sendkeyToAlert(WebDriver driver, String keysToSend) {
        waitForAlertPresence(driver).sendKeys(keysToSend);
    }

    public void switchToWindowByID(String expectedID) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs)
            if (!id.equals(expectedID)) {
                driver.switchTo().window(id);
                break;
            }
    }

    public void switchToWindowByTitle(String expectedTitle) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs) {
            driver.switchTo().window(id);
            sleepInSeconds(2);
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedTitle))
                break;
        }
    }

    public void closeAllWindowWithoutParent(String parentID) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs)
            if (!id.equals(parentID))  {
                driver.switchTo().window(id);
                driver.close();
            }
        driver.switchTo().window(parentID);
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
