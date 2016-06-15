package com.harishkannarao.angularjs.webapp.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public boolean isOnValidPage() {
        return !webDriver.findElements(By.id("qa-login-page-id")).isEmpty();
    }

    public void enterUserName(String userName) {
        WebElement userNameInput = webDriver.findElement(By.id("username"));
        userNameInput.clear();
        userNameInput.sendKeys(userName);
    }

    public void enterPassword(String password) {
        WebElement userNameInput = webDriver.findElement(By.id("password"));
        userNameInput.clear();
        userNameInput.sendKeys(password);
    }

    public void clickLoginButton() {
        webDriver.findElement(By.id("login")).click();
    }
}
