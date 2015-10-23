package com.harishkannarao.angularjs.webapp.step;

import com.harishkannarao.angularjs.webapp.page.GenericPage;
import com.harishkannarao.angularjs.webapp.page.PingPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import javax.inject.Inject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PingPageSteps {
    @Inject
    private GenericPage genericPage;
    @Inject
    private PingPage pingPage;

    @Given("^I go to ping page$")
    public void goToPingPage() throws Throwable {
        pingPage.navigate();
    }

    @Then("^I should be on ping page$")
    public void assertPingPage() throws Throwable {
        assertTrue(pingPage.isOnValidPage());
    }

    @Then("^And I should url as \"(.*)\" on ping page$")
    public void assertUrl(String expectedUrl) throws Throwable {
        assertEquals(genericPage.getCurrentUrl(), expectedUrl);
    }
}
