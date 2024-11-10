package pageUIs.user;

public class BaseElementUI {
    public static final String NOP_COMMERCE_LOGO = "xpath=//div[@class='header-logo']//img";
    public final static String UPLOAD_FILE_NAME_BLUE = "xpath=//input[@name='files[]']";
    public static final String UPLOAD_FILE_NAME_GO_FILE = "xpath=//input[@type='file']";
    public static final String DYNAMIC_HEADER_LINK_BY_NAME = "xpath=//div[@class='header-links']//a[contains(string(), '%s')]";
    public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
    public static final String DYNAMIC_TEXTBOX_ERROR_MSG = "id=%s-error";
    public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
}
