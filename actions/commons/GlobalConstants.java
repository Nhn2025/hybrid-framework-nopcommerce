package commons;

import org.checkerframework.checker.units.qual.s;

import java.io.File;

public class GlobalConstants {
    // Server Url: Dev/ Testing/ Staging/ Product
    // Database: Dev/ Testing/ Staging/ Product
    // Timeout: Short/ Long
    // Username/ Pass
    // Third Party: Sandbox account
    // Relative Project Path
    // OS Name
    // Cloud Testing: Browserstack/ Saucelab/ CrossbrowserTesting (Access token/ ID)
    //..

    public static final String DEV_USER_URL = "http://demo.nopcommerce";
    public static final String DEV_ADMIN_URL = "http://demo.nopcommerce/login?ReturnUrl=%2Fadmin";
    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 30;
    public static final String DEV_ADMIN_USERNAME = "nhu@automationfc.vn";
    public static final String DEV_ADMIN_PASSWORD = "nhu@automationfc.vn";
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String RELATIVE_PROJECT_PATH = System.getProperty("user.dir");
    public static final String UPLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
    public static final String DOWNLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "downloadFiles" + File.separator;
}
