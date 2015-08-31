package com.harishkannarao.angularjs.webapp.page;

public class GenericPage extends BasePage {

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public void navigateToHomePage() {
        webDriver.navigate().to(APPLICATION_URL);
        webDriver.navigate().refresh();
    }
}
