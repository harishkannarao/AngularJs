package com.harishkannarao.angularjs.webapp.page;

public class IndexPage extends BasePage {
    public void navigate() {
        webDriver.navigate().to(APPLICATION_URL + "/app/index.html");
        webDriver.navigate().refresh();
    }

    public void navigateToPath(String path) {
        webDriver.navigate().to(APPLICATION_URL + "/app/index.html" + path);
        webDriver.navigate().refresh();
    }
}
