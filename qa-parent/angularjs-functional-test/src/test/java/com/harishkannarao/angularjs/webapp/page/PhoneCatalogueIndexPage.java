package com.harishkannarao.angularjs.webapp.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

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

}
