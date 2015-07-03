package com.harishkannarao.angularjs.webapp.page;

import org.openqa.selenium.By;

public class IndexPage extends PageBase{

    public void navigate() {
        webDriver.get(APPLICATION_URL + "/index.jsp");
    }

    public boolean isHelloWorldMessageDisplayed() {
        return !webDriver.findElements(By.id("hwMsg")).isEmpty();
    }
}
