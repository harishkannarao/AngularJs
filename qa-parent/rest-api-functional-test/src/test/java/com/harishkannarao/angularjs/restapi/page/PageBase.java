package com.harishkannarao.angularjs.restapi.page;

import org.openqa.selenium.WebDriver;

import javax.inject.Inject;

public class PageBase {
    @Inject
    protected WebDriver webDriver;
    protected static final String APP_SERVER_URL = System.getProperty("appServerUrl", "http://localhost:8080");
    protected static final String APPLICATION_CONTEXT = "restapi";
    protected static final String PATH_SEPARATOR = "/";
    protected static final String APPLICATION_URL = APP_SERVER_URL + PATH_SEPARATOR + APPLICATION_CONTEXT;

    public String getTitle() {
        return webDriver.getTitle();
    }

}
