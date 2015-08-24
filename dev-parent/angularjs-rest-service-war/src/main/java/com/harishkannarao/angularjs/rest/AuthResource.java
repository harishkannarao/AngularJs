package com.harishkannarao.angularjs.rest;

import com.harishkannarao.angularjs.model.AuthAccessElement;
import com.harishkannarao.angularjs.model.AuthLoginElement;
import com.harishkannarao.angularjs.service.AuthService;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/properties")
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


}
