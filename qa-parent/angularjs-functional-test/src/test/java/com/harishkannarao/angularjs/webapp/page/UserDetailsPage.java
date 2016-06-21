package com.harishkannarao.angularjs.webapp.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class UserDetailsPage extends BasePage {

    public boolean isOnValidPage() {
        return !webDriver.findElements(By.id("qa-user-details-page-id")).isEmpty();
    }

    public void navigate() {
        webDriver.navigate().to(APPLICATION_SSL_URL + "/app/index.html#/userDetails");
        webDriver.navigate().refresh();
    }

    public String getUserName() {
        return webDriver.findElement(By.id("qa-user-name-id")).getText();
    }

    public String getAuthToken() {
        return webDriver.findElement(By.id("qa-auth-token-id")).getText();
    }

    public List<String> getRoles() {
        return webDriver.findElements(By.className("qa-auth-permission")).stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
