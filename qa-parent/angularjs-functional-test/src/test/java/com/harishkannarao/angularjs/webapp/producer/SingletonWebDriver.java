package com.harishkannarao.angularjs.webapp.producer;

import com.gargoylesoftware.htmlunit.WebClient;
import com.harishkannarao.angularjs.webapp.util.PropertiesReference;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class SingletonWebDriver {

    private static synchronized WebDriver   createAndCacheWebDriver() {
        class WebDriverFactory implements Supplier<WebDriver> {
            private final WebDriver webDriverInstance;

            private static final String DRIVER_KEY = "driver";
            private static final String HTML_UNIT_DRIVER = "htmlunit";
            private static final String HTML_UNIT_DRIVER_IGNORE_JS_ERROR = "htmlunit_ignore_js_error";
            private static final String FIREFOX_DRIVER = "firefox";
            private static final String PHANTOMJS_DRIVER = "phantomjs";

            public WebDriverFactory() {
                webDriverInstance = createWebDriver();
                Runtime.getRuntime().addShutdownHook(new Thread("WebDriver shutdown thread") {
                    public void run() {
                        webDriverInstance.quit();
                    }
                });
            }

            private WebDriver createWebDriver() {
                WebDriver driver = null;
                String driverType = PropertiesReference.MAVEN_PROPERTIES.getProperty(DRIVER_KEY);
                if (HTML_UNIT_DRIVER.equals(driverType)) {
                    driver = new HtmlUnitDriver(true);
                } else if(HTML_UNIT_DRIVER_IGNORE_JS_ERROR.equals(driverType)) {
                    driver = new HtmlUnitDriver(true){
                        protected WebClient modifyWebClient(WebClient client) {
                            client.getOptions().setThrowExceptionOnScriptError(false);
                            return client;
                        }
                    };
                } else if (FIREFOX_DRIVER.equals(driverType)) {
                    driver = new FirefoxDriver();
                    driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
                } else if (PHANTOMJS_DRIVER.equals(driverType)) {
                    driver = new PhantomJSDriver();
                    driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
                }
                return driver;
            }

            @Override
            public WebDriver get() {
                return webDriverInstance;
            }
        }

        if(!WebDriverFactory.class.isInstance(webDriverSupplier)) {
            webDriverSupplier = new WebDriverFactory();
        }
        return webDriverSupplier.get();
    }

    private static Supplier<WebDriver> webDriverSupplier = SingletonWebDriver::createAndCacheWebDriver;

    public static WebDriver getInstance() {
        return webDriverSupplier.get();
    }

}
