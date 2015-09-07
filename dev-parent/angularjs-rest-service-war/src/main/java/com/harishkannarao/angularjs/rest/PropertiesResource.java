package com.harishkannarao.angularjs.rest;

import com.harishkannarao.angularjs.model.ApplicationPropertiesBuilder;
import com.harishkannarao.angularjs.util.ModulePropertyFileLoader;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/properties")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class PropertiesResource {

    @Inject
    private ModulePropertyFileLoader modulePropertyFileLoader;

    @GET
    @Path("/module")
    public Response getPhoneById() {
        ApplicationPropertiesBuilder applicationPropertiesBuilder = ApplicationPropertiesBuilder.newBuilder()
                .setSampleString(modulePropertyFileLoader.getSampleString())
                .setListOfString(modulePropertyFileLoader.getListOfString())
                .setSampleLong(modulePropertyFileLoader.getSampleLong())
                .setEnablePropertyChangeListener(modulePropertyFileLoader.getEnablePropertyChangeListener());
        return Response.ok(applicationPropertiesBuilder.build()).build();
    }
}
