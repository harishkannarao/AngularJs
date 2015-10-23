package com.harishkannarao.angularjs.webapp.page;

import org.openqa.selenium.By;

public class PingPage extends BasePage {
    public void navigate() {
        webDriver.navigate().to(APPLICATION_URL + "/ping.html");
        webDriver.navigate().refresh();
    }

    public boolean isOnValidPage() {
        return !webDriver.findElements(By.id("qa-ping-page-id")).isEmpty();
    }
}
