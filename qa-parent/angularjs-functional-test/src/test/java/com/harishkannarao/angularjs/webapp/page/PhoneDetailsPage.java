package com.harishkannarao.angularjs.webapp.page;

import org.openqa.selenium.By;

public class PhoneDetailsPage extends BasePage{

    public void navigate(Long phoneId) {
        webDriver.navigate().to(APPLICATION_URL + "/app/index.html#/phones/" + phoneId);
        webDriver.navigate().refresh();
    }

    public boolean isOnValidPage() {
        return !webDriver.findElements(By.id("qa-phone-details-page-id")).isEmpty();
    }

    public Long getPhoneId() {
        return Long.parseLong(webDriver.findElement(By.className("qa-phone-id")).getAttribute("id"));
    }
}
