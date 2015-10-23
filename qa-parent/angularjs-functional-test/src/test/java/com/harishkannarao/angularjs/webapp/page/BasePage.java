package com.harishkannarao.angularjs.webapp.page;

import com.harishkannarao.angularjs.webapp.util.PropertiesReference;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import javax.inject.Inject;

public class BasePage {
    @Inject
    protected WebDriver webDriver;
    @Inject
    protected JavascriptExecutor javascriptExecutor;
    protected static final String APP_SERVER_SSL_URL = PropertiesReference.MAVEN_PROPERTIES.getProperty("appServerSslUrl");
    protected static final String APP_SERVER_URL = PropertiesReference.MAVEN_PROPERTIES.getProperty("appServerUrl");
    protected static final String APPLICATION_CONTEXT = "angularjs";
    protected static final String PATH_SEPARATOR = "/";
    protected static final String APPLICATION_SSL_URL = APP_SERVER_SSL_URL + PATH_SEPARATOR + APPLICATION_CONTEXT;
    protected static final String APPLICATION_URL = APP_SERVER_URL + PATH_SEPARATOR + APPLICATION_CONTEXT;

    protected static final String ANGULARJS_CALLBACK = "var callback = arguments[arguments.length - 1];" +
            "angular.element(document.body).injector().get('$browser').notifyWhenNoOutstandingRequests(callback);";

    public String getTitle() {
        return webDriver.getTitle();
    }

    public void waitForAngularRequestsToFinish() {
        javascriptExecutor.executeAsyncScript(ANGULARJS_CALLBACK);
    }

}
