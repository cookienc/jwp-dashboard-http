package org.apache.coyote.http.request;

import org.apache.coyote.http.common.HttpBody;
import org.apache.coyote.http.common.HttpHeader;
import org.apache.coyote.http.common.HttpHeaders;

import java.util.Map;

public class HttpRequest {

    private final RequestLine requestLine;
    private final HttpHeaders headers;
    private final HttpBody httpBody;

    public HttpRequest(final RequestLine requestLine, final HttpHeaders headers, final HttpBody httpBody) {
        this.requestLine = requestLine;
        this.headers = headers;
        this.httpBody = httpBody;
    }

    public boolean isSameRequestMethod(final HttpMethod httpMethod) {
        return requestLine.isSameRequestMethod(httpMethod);
    }

    public boolean containsRequestUri(final String uri) {
        return requestLine.containsRequestUri(uri);
    }

    public boolean hasQueryString() {
        return requestLine.containsRequestUri("?");
    }

    public boolean isEndsWithRequestUri(final String uri) {
        return requestLine.isEndsWithRequestUri(uri);
    }

    public boolean containsHeader(final HttpHeader headerName) {
        return headers.containsKey(headerName);
    }

    public String getHeader(final HttpHeader httpHeader) {
        return headers.get(httpHeader);
    }

    public QueryString getQueryString() {
        return requestLine.getQueryString();
    }

    public Map<String, String> getParsedBody() {
        return httpBody.parseBodyParameters();
    }

    public RequestUri getRequestUri() {
        return requestLine.getRequestUri();
    }

    public RequestLine getRequestLine() {
        return requestLine;
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

    public HttpBody getHttpBody() {
        return httpBody;
    }
}
