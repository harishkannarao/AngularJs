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

    public boolean isLinkDisplayed(String linkText) {
        return !webDriver.findElements(By.linkText(linkText)).isEmpty();
    }

    public boolean isLoggedIn() {
        return !webDriver.findElements(By.linkText("Logout")).isEmpty();
    }

    public void clickLogout() {
        webDriver.findElement(By.linkText("Logout")).click();
    }
}
