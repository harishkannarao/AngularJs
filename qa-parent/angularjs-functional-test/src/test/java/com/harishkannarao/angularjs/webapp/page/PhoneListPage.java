package com.harishkannarao.angularjs.webapp.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class PhoneListPage extends BasePage {

    public void navigate() {
        webDriver.navigate().to(APPLICATION_URL + "/app/index.html#/phones");
        webDriver.navigate().refresh();
    }

    public int getPhoneCount() {
        return webDriver.findElements(By.className("phone-name")).size();
    }

    public void enterQuery(String query) {
        WebElement queryInput = webDriver.findElement(By.id("query"));
        queryInput.clear();
        queryInput.sendKeys(query);
    }

    public void clearQuery() {
        WebElement queryInput = webDriver.findElement(By.id("query"));
        queryInput.clear();
    }

    public String getName() {
        return webDriver.findElement(By.id("name")).getText();
    }

    public String getSortByValue() {
        Select select = new Select(webDriver.findElement(By.id("orderProp")));
        return select.getFirstSelectedOption().getAttribute("value");
    }

    public void setSortByValue(String sortByValue) {
        Select select = new Select(webDriver.findElement(By.id("orderProp")));
        select.selectByValue(sortByValue);
    }

    public List<String> getDisplayedPhoneNames() {
        return webDriver.findElements(By.className("phone-name")).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getDisplayedPhoneSnippets() {
        return webDriver.findElements(By.className("phone-snippet")).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getPhoneListImageSources() {
        return webDriver.findElements(By.className("qa-phone-list-img")).stream().map(webElement -> webElement.getAttribute("src")).collect(Collectors.toList());
    }

    public boolean isOnValidPage() {
        return !webDriver.findElements(By.id("qa-phone-list-page-id")).isEmpty();
    }

}
