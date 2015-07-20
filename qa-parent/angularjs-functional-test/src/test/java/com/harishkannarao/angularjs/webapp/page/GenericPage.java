package com.harishkannarao.angularjs.webapp.page;

public class GenericPage extends BasePage {

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }
}
