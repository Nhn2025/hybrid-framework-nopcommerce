package javaBasic;

import org.testng.annotations.Test;

public class Topic_04_Rest_Parameter {
    String addressLink = "//div[@class='side-2']//a[text() = 'Addresses']";
    String pageOrders = "//div[@class='side-2']//a[text() = 'Orders']";

    String sidebarLink = "//div[@class='side-2']//a[text() = '%s']";

    String dynamicLink = "//div[@class='%s']//a[text() = '%s']";

    String dynamicCountry = "//div[@class='%s']/div[@id='%s']//a[text() = '%s']";

    @Test
    public void TC_01_Rest_Param() {
        // Cố định
        clickToElement(addressLink);
        clickToElement(pageOrders);

        // 1 parameter
        clickToElement(sidebarLink, "Addresses");
        clickToElement(sidebarLink, "Orders");

        // 2 parameter
        clickToElement(dynamicLink,"footer", "Orders");
        clickToElement(dynamicLink,"footer", "Blog");
        clickToElement(dynamicLink,"header", "Register");
        clickToElement(dynamicLink,"header", "Login");

        // 3 parameter
        clickToElement(dynamicCountry, "header", "computer", "Lenovo");
        clickToElement(dynamicCountry, "header", "mobile", "Samsung");
    }

    // Hàm để click vào 1 element cố định
    public void clickToElement(String locatorValue) {
        System.out.println("Click to: " + locatorValue);
    }

    // Hàm để click vào 1 element ko cố định (dynamic) vs bất kì tham số
    public void clickToElement(String locatorValue, String... values) { // Mảng String
        locatorValue = String.format(locatorValue, (Object[]) values); // String.format(String, Object)
        System.out.println("Click to: " + locatorValue);
    }

}
