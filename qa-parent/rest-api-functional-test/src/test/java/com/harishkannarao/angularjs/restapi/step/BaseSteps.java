package com.harishkannarao.angularjs.restapi.step;

import com.harishkannarao.angularjs.restapi.client.SingletonRestClient;

import javax.ws.rs.client.WebTarget;

public class BaseSteps {
    protected static final String APP_SERVER_URL = System.getProperty("appServerUrl", "http://localhost:8080");
    protected static final String APPLICATION_CONTEXT = "restapi";
    protected static final String PATH_SEPARATOR = "/";
    protected static final String APPLICATION_URL = APP_SERVER_URL + PATH_SEPARATOR + APPLICATION_CONTEXT;

    protected static final WebTarget serverTarget = SingletonRestClient.getInstance().target(APP_SERVER_URL);
    protected static final WebTarget restApiBaseTarget = SingletonRestClient.getInstance().target(APPLICATION_URL + "/service");
}
