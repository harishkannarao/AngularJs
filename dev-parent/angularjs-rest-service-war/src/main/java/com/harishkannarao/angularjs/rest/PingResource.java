package com.harishkannarao.angularjs.rest;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ping")
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class PingResource {

    private static String PING_RESPONSE = "Ping!!!";

    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public Response doPing() {
        return Response.ok(PING_RESPONSE).build();
    }
}
