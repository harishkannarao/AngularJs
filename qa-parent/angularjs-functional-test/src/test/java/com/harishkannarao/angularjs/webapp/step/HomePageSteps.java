package com.harishkannarao.angularjs.webapp.step;

import com.harishkannarao.angularjs.webapp.page.GenericPage;
import cucumber.api.java.en.Given;

import javax.inject.Inject;

public class HomePageSteps {

    @Inject
    private GenericPage genericPage;

    @Given("^I go to application home page$")
    public void I_go_to_application_home_page() throws Throwable {
        genericPage.navigateToHomePage();
    }
}
