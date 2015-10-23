package com.harishkannarao.angularjs.webapp.step;

import com.harishkannarao.angularjs.webapp.page.GenericPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import javax.inject.Inject;

import static org.testng.Assert.assertEquals;

public class HomePageSteps {

    @Inject
    private GenericPage genericPage;

    @Given("^I go to application home page$")
    public void I_go_to_application_home_page() throws Throwable {
        genericPage.navigateToHomePage();
    }

    @Given("^I go to application home page on http$")
    public void I_go_to_application_home_page_on_http() throws Throwable {
        genericPage.navigateToHomePageOnHttp();
    }

    @And("^I should see url as \"(.*)\"$")
    public void I_should_see_url_as(String expectedUrl) throws Throwable {
        assertEquals(genericPage.getCurrentUrl(), expectedUrl);
    }
}
