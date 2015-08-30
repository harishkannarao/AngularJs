package com.harishkannarao.angularjs.rest;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/home")
@Stateless
public class HomeResource {

    @GET
    public Response redirectToIndexPage(@Context UriInfo uriInfo) {
        return Response.seeOther(uriInfo.getBaseUriBuilder().path("../app/index.html").build()).build();
    }
}
