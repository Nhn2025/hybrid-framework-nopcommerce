package pageObjects.user;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.user.FooterPageUI;
import pageUIs.user.PageBaseUI;

public class FooterPageObject extends BasePage {
    WebDriver driver;

    public FooterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public SiteMapPageObject openSiteMapPage() {
        waitForElementClickable(driver, FooterPageUI.SITE_MAP_LINK_TEXT);
        clickToElement(driver, FooterPageUI.SITE_MAP_LINK_TEXT);
        return PageGeneratorManager.getSiteMapPage(driver);
    }

    public ShoppingCartPageObject openShoppingCartPage() {
        waitForElementClickable(driver, FooterPageUI.SHOPPING_CART_LINK_TEXT);
        clickToElement(driver, FooterPageUI.SHOPPING_CART_LINK_TEXT);
        return PageGeneratorManager.getShoppingCartPage(driver);
    }

    public SearchPageObject openSearchPage() {
        waitForElementClickable(driver, FooterPageUI.SEARCH_LINK_TEXT);
        clickToElement(driver, FooterPageUI.SEARCH_LINK_TEXT);
        return PageGeneratorManager.getSearchPage(driver);
    }

    public WishlistPageObject openWishlistPage() {
        waitForElementClickable(driver, FooterPageUI.WISHLIST_LINK_TEXT);
        clickToElement(driver, FooterPageUI.WISHLIST_LINK_TEXT);
        return PageGeneratorManager.getWishlistPage(driver);
    }
}
