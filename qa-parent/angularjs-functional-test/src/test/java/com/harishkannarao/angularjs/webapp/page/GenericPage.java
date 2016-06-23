package com.harishkannarao.angularjs.webapp.page;

import org.openqa.selenium.logging.LogEntries;

public class GenericPage extends BasePage {

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public void navigateToHomePage() {
        webDriver.navigate().to(APPLICATION_SSL_URL);
        webDriver.navigate().refresh();
    }

    public void navigateToHomePageOnHttp() {
        webDriver.navigate().to(APPLICATION_URL);
        webDriver.navigate().refresh();
    }

    public LogEntries getLogEntries() {
        return webDriver.manage().logs().get("browser");
    }
}
