package com.harishkannarao.angularjs.webapp.page;

import org.openqa.selenium.By;

public class IndexPage extends BasePage {
    public void navigate() {
        webDriver.navigate().to(APPLICATION_SSL_URL + "/app/index.html");
        webDriver.navigate().refresh();
    }

    public void navigateToPath(String path) {
        webDriver.navigate().to(APPLICATION_SSL_URL + "/app/index.html" + path);
        webDriver.navigate().refresh();
    }

    public void clickLogin() {
        webDriver.findElement(By.linkText("Login")).click();
    }
}
