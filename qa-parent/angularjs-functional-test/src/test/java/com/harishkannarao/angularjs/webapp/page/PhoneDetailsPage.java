package com.harishkannarao.angularjs.webapp.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

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

    public String getAdditionalFeatures() {
        return webDriver.findElement(By.id("qa-phone-additional-features")).getText();
    }

    public String getAndroidOs() {
        return webDriver.findElement(By.id("qa-phone-android-os")).getText();
    }

    public String getAndroidUi() {
        return webDriver.findElement(By.id("qa-phone-android-ui")).getText();
    }

    public List<String> getAvailabilityList() {
        return webDriver.findElements(By.className("qa-phone-availability")).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public String getStandbyTime() {
        return webDriver.findElement(By.id("qa-phone-battery-standby-time")).getText();
    }

    public String getTalkTime() {
        return webDriver.findElement(By.id("qa-phone-battery-talk-time")).getText();
    }

    public String getBatteryType() {
        return webDriver.findElement(By.id("qa-phone-battery-type")).getText();
    }

    public String getCameraFeatures() {
        return webDriver.findElement(By.id("qa-phone-features")).getText();
    }

    public String getCameraPrimary() {
        return webDriver.findElement(By.id("qa-phone-camera-primary")).getText();
    }
}
