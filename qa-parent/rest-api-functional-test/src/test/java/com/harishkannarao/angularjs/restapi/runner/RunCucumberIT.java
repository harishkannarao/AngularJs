package com.harishkannarao.angularjs.restapi.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        strict = true,
        plugin = {
                "pretty","json:target/Cucumber.json",
                "html:target/cucumber-html-report"
        },
        // included all *.features in src/test/resources
        features="src/test/resources",
        // Top package in src/test/java
        glue = "com.harishkannarao.angularjs.restapi"
)
public class RunCucumberIT extends AbstractTestNGCucumberTests {

}
