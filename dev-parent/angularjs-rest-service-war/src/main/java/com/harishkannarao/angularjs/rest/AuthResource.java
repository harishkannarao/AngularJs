package com.harishkannarao.angularjs.rest;

import com.harishkannarao.angularjs.model.AuthAccessElement;
import com.harishkannarao.angularjs.model.AuthLoginElement;
import com.harishkannarao.angularjs.model.User;
import com.harishkannarao.angularjs.service.AuthService;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.Optional;

@Path("/auth")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Stateless
public class AuthResource {

    @Inject
    private AuthService authService;

    @POST
    @Path("/login")
    @PermitAll
    public Response login(AuthLoginElement authLoginElement) {
        Optional<AuthAccessElement> authAccessElementOptional = authService.login(authLoginElement);
        if (authAccessElementOptional.isPresent()) {
            return Response.ok(authAccessElementOptional.get()).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @GET
    @Path("/authAccess")
    @RolesAllowed({"role2", "role3"})
    public Response getAuthAccessElement(@Context HttpHeaders hh) {
        MultivaluedMap<String, String> headerParams = hh.getRequestHeaders();
        String username = headerParams.getFirst(AuthAccessElement.PARAM_AUTH_ID);
        String authtoken = headerParams.getFirst(AuthAccessElement.PARAM_AUTH_TOKEN);
        Optional<AuthAccessElement> authAccessElementOptional = authService.getAuthAccessElement(username, authtoken);
        if (authAccessElementOptional.isPresent()) {
            return Response.ok(authAccessElementOptional.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/logout")
    @PermitAll
    public Response logout(@Context HttpHeaders hh) {
        MultivaluedMap<String, String> headerParams = hh.getRequestHeaders();
        String username = headerParams.getFirst(AuthAccessElement.PARAM_AUTH_ID);
        String authtoken = headerParams.getFirst(AuthAccessElement.PARAM_AUTH_TOKEN);
        authService.logout(username, authtoken);
        return Response.status(Response.Status.NO_CONTENT).build();
    }


}
