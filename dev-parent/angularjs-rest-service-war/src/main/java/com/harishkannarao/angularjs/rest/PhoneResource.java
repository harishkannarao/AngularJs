package com.harishkannarao.angularjs.rest;

import com.harishkannarao.angularjs.model.Phone;
import com.harishkannarao.angularjs.service.PhoneService;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/phones")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class PhoneResource {

    @Inject
    private PhoneService phoneService;

    @GET
    public Response getAllPhoneSummaries() {
        return Response.ok(phoneService.getAllPhoneSummaries()).build();
    }

    @GET
    @Path("/{phoneId}")
    public Response getPhoneById(@PathParam("phoneId") Long phoneId) {
        Optional<Phone> phoneOptional = phoneService.getPhoneById(phoneId);
        if(phoneOptional.isPresent()) {
            return Response.ok(phoneOptional.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
