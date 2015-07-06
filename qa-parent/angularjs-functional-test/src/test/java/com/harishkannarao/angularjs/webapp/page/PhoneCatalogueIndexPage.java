package com.harishkannarao.angularjs.webapp.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PhoneCatalogueIndexPage extends PageBase {

    public void navigate() {
        webDriver.get(APPLICATION_URL + "/app/index.html");
    }

    public int getPhoneCount() {
        return webDriver.findElements(By.className("phone-name")).size();
    }

    public void enterQuery(String query) {
        WebElement queryInput = webDriver.findElement(By.id("query"));
        queryInput.clear();
        queryInput.sendKeys(query);
    }

    public String getName() {
        return webDriver.findElement(By.id("name")).getText();
    }
}
