package com.harishkannarao.angularjs.rest;

import com.harishkannarao.angularjs.model.UpdatePropertyRequest;
import com.harishkannarao.angularjs.service.PropertyService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/properties")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Stateless
public class PropertyUpdateResource {

    @Inject
    private PropertyService propertyService;

    @POST
    @Path("/module")
    public Response updateModuleProperty(UpdatePropertyRequest updatePropertyRequest) {
        propertyService.addOrUpdateModuleProperty(updatePropertyRequest.getKey(), updatePropertyRequest.getValue());
        return Response.ok().build();
    }
}
