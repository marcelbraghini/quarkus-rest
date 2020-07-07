package br.com.marcelbraghini.quarkusrest.interceptor;

import io.vertx.core.http.HttpServerRequest;
import org.jboss.logging.Logger;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class LoggingFilter implements ContainerRequestFilter {

    private static final Logger logger = Logger.getLogger(LoggingFilter.class);

    @Context
    public UriInfo info;

    @Context
    public HttpServerRequest request;

    @Override
    public void filter(ContainerRequestContext context) throws IOException {
        final String method = context.getMethod();
        final String path = info.getPath();
        final String address = request.remoteAddress().toString();
        logger.infof("Request %s %s from IP %s", method, path, address);
    }
}
