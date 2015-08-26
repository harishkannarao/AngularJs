package com.harishkannarao.angularjs.interceptor.security;

import com.harishkannarao.angularjs.model.AuthAccessElement;
import com.harishkannarao.angularjs.service.AuthService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Provider
public class AuthSecurityInterceptor implements ContainerRequestFilter {
    // 401 - Access denied
    private static final Response ACCESS_UNAUTHORIZED = Response.status(Response.Status.UNAUTHORIZED).entity("Not authorized.").build();

    @Inject
    private AuthService authService;

    @Context
    private HttpServletRequest request;

    @Context
    private ResourceInfo resourceInfo;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        // Get AuthId and AuthToken from HTTP-Header.
        String authId = containerRequestContext.getHeaderString(AuthAccessElement.PARAM_AUTH_ID);
        String authToken = containerRequestContext.getHeaderString(AuthAccessElement.PARAM_AUTH_TOKEN);

        // Get method invoked.
        Method methodInvoked = resourceInfo.getResourceMethod();
        if (methodInvoked.isAnnotationPresent(AllowRoles.class)) {
            AllowRoles allowRolesAnnotation = methodInvoked.getAnnotation(AllowRoles.class);
            Set<String> rolesAllowed = new HashSet<>(Arrays.asList(allowRolesAnnotation.value()));

            if (!authService.isAuthorized(authId, authToken, rolesAllowed)) {
                containerRequestContext.abortWith(ACCESS_UNAUTHORIZED);
            }
        } else if (methodInvoked.isAnnotationPresent(DenyAllRoles.class)) {
            containerRequestContext.abortWith(ACCESS_UNAUTHORIZED);
        } else if (methodInvoked.isAnnotationPresent(AllowAllRoles.class)) {
            //do nothing, allow access to every one
        }
    }
}
