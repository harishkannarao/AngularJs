package com.harishkannarao.angularjs.webapp.step;

import com.harishkannarao.angularjs.webapp.page.IndexPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import static org.testng.Assert.assertTrue;

@ApplicationScoped
public class HelloWorldSteps {

    @Inject
    private IndexPage indexPage;

    @Given("^I am on index page$")
    public void I_am_on_index_page() throws Throwable {
        indexPage.navigate();
    }

    @Then("^I should see hello world message$")
    public void I_should_see_hello_world_message() throws Throwable {
        assertTrue(indexPage.isHelloWorldMessageDisplayed());
    }
}
