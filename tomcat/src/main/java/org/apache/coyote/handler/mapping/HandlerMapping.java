package org.apache.coyote.handler.mapping;

import java.io.IOException;

public interface HandlerMapping {

    boolean supports(final String httpMethod, final String requestUri);

    String handle(final String requestUri, final String requestBody) throws IOException;
}