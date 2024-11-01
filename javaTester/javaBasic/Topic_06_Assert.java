package javaBasic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_06_Assert {

    @Test
    public void TC_01() {
        // True/ False: Nó sẽ nhận vào tham số là kiểu dữ liệu boolean
        // isDisplayed/ isSelected/ isEnable/ isMultiple -> boolean
        // isPageLoadedSuccess/ isImageLoaded/ waitForElementVisible/ waitForListElementInvisinle -> boolean
        // areExpectedTextInInnerText
        // Asssert.assertTrue(adminDashboardPage.isPageLoadedSuccess(driver));

        boolean status = true;
        Assert.assertTrue(status);

        status = false;
        Assert.assertFalse(status);

        // Equals: Nó nhận vào 2 tham số có kiểu dữ liệu tương ứng nhau
        // getText/ getAttribute/ getCss/ getSize
        String fullName = "Automation FC";

        Assert.assertEquals(fullName, "Automation FC");
    }

}
