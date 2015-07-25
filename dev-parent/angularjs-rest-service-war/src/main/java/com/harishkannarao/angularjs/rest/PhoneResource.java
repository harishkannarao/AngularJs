package com.harishkannarao.angularjs.rest;

import com.harishkannarao.angularjs.service.PhoneService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/phones")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Stateless
public class PhoneResource {

    @Inject
    private PhoneService phoneService;

    @GET
    public Response getAllPhones() {
        return Response.ok(phoneService.getAllPhoneSummaries()).build();
    }
}
