package com.harishkannarao.angularjs.webapp.page;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public boolean isOnValidPage() {
        return !webDriver.findElements(By.id("qa-login-page-id")).isEmpty();
    }
}
