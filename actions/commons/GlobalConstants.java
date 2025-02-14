package commons;

import java.io.File;

public class GlobalConstants {

    // App Infor User
    public static final String DEV_USER_URL = "http://demo.nopcommerce";

    //  App Infor Admin
    public static final String DEV_ADMIN_URL = "http://demo.nopcommerce/login?ReturnUrl=%2Fadmin";
    public static final String DEV_ADMIN_USERNAME = "nhu@automationfc.vn";
    public static final String DEV_ADMIN_PASSWORD = "nhu@automationfc.vn";

    // Wait Infor
    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 30;

    // System Infor
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String SEPARATOR = File.separator;
    public static final String JAVA_VERSION = System.getProperty("java.version");

    // Download/ Upload file
    public static final String UPLOAD_PATH = PROJECT_PATH + SEPARATOR + "uploadFiles" + SEPARATOR;
    public static final String DOWNLOAD_PATH = PROJECT_PATH + SEPARATOR + "downloadFiles" + SEPARATOR;

    // Browser Logs/ Extension
    public static final String BROWSER_LOG_PATH = PROJECT_PATH + SEPARATOR + "browserLogs" + SEPARATOR;
    public static final String BROWSER_EXTENSION_PATH = PROJECT_PATH + SEPARATOR + "browserExtensions" + SEPARATOR;

    // HTML Report Folder
    public static final String REPORTNG_PATH = PROJECT_PATH + SEPARATOR + "htmlReportNG" + SEPARATOR;
    public static final String EXTEN_PATH = PROJECT_PATH + SEPARATOR + "htmlExtent" + SEPARATOR;
    public static final String ALLURE_PATH = PROJECT_PATH + SEPARATOR + "htmlAllure" + SEPARATOR;

    // Data Test/ Enviroment
    public static final String DATA_TEST_PATH = PROJECT_PATH + SEPARATOR + "dataTest" + SEPARATOR;
    public static final String ENVIROMENT_CONFIG_PATH = PROJECT_PATH + SEPARATOR + "enviromentConfig" + SEPARATOR;

    //
    public static final String JIRA_SITE_URL = "https://dnhu-automation.atlassian.net";
    public static final String JIRA_USERNAME = "dnhu122025@gmail.com";
    public static final String JIRA_API_KEY = "ATATT3xFfGF05rVyAkWHHfeLs8aCR6Pt9tOsJpb4KH-gTCqY4MZVDzxr73qpNrY_V70iEEUbx0shIXB1i_VsC9P1UYXynLVRgHjU0O62zubadSnkRZ89cVEcpTl7BDz7eifdlRELygM18iLT4YSPsyNQhHPQNzK9W23pKbYG-aObnHn1sNafw-k=B769095F";
    public static final String JIRA_PROJECT_KEY = "SCRUM";
}
