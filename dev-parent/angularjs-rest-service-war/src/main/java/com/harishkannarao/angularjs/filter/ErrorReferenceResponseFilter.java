package com.harishkannarao.angularjs.filter;

import com.harishkannarao.angularjs.constants.HttpHeaderErrorKeys;
import com.harishkannarao.angularjs.model.AuthAccessElement;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.Status.Family;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.StringJoiner;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Provider
public class ErrorReferenceResponseFilter implements ContainerResponseFilter {
    private static final Logger LOGGER = Logger.getLogger(ErrorReferenceResponseFilter.class.getName());
    private static final String BOOLEAN_TRUE_AS_STRING = Boolean.TRUE.toString().toLowerCase();

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        Family statusFamily = containerResponseContext.getStatusInfo().getFamily();
        Status status = Status.fromStatusCode(containerResponseContext.getStatus());
        if (statusFamily.equals(Family.SERVER_ERROR) || status.equals(Status.FORBIDDEN)) {
            String errorReference = UUID.randomUUID().toString();
            String acceptTypes = containerRequestContext.getAcceptableMediaTypes().stream().map(MediaType::getType).collect(Collectors.joining(","));
            String errorMessage = new StringJoiner(":", "[", "]")
                    .add(errorReference)
                    .add(containerRequestContext.getHeaderString(AuthAccessElement.PARAM_AUTH_ID))
                    .add(containerRequestContext.getUriInfo().getAbsolutePath().toString())
                    .add(containerRequestContext.getMethod())
                    .add(acceptTypes)
                    .add(String.valueOf(status.getStatusCode()))
                    .add(containerResponseContext.getHeaderString(HttpHeaderErrorKeys.ERROR_CODE_KEY.getValue()))
                    .add(containerResponseContext.getHeaderString(HttpHeaderErrorKeys.ERROR_MESSAGE_KEY.getValue()))
                    .toString();
            LOGGER.severe(errorMessage);
            containerResponseContext.getHeaders().add(HttpHeaderErrorKeys.ERROR_REFERENCE_KEY.getValue(), errorReference);
        }
        if (statusFamily.equals(Family.CLIENT_ERROR)) {
            containerResponseContext.getHeaders().add(HttpHeaderErrorKeys.APPLICATION_VALIDATION_ERROR_KEY.getValue(), BOOLEAN_TRUE_AS_STRING);
        }
    }
}
