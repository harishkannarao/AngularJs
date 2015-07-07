package com.harishkannarao.angularjs.restapi.step;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class BaseSteps {
    protected static final String APP_SERVER_URL = System.getProperty("appServerUrl", "http://localhost:8080");
    protected static final String APPLICATION_CONTEXT = "restapi";
    protected static final String PATH_SEPARATOR = "/";
    protected static final String APPLICATION_URL = APP_SERVER_URL + PATH_SEPARATOR + APPLICATION_CONTEXT;

    protected Client restClient = ClientBuilder.newClient();
}
