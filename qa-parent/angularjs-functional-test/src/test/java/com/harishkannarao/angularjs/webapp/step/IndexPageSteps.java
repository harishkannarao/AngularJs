package com.harishkannarao.angularjs.webapp.step;

import com.harishkannarao.angularjs.webapp.page.IndexPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class IndexPageSteps {

    public static final String SOME_JUNK_URL = "#/someJunkUrl";

    @Inject
    private IndexPage indexPage;

    @Given("^I go to index page$")
    public void I_go_to_index_page() throws Throwable {
        indexPage.navigate();
    }

    @Given("^I go to a non-existing page$")
    public void I_go_to_a_non_existing_page() throws Throwable {
        indexPage.navigateToPath(SOME_JUNK_URL);
    }
}
