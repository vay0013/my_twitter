package com.vay.managerapp.security;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;

import java.io.IOException;

public class OAuthClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {
    /**
     * Intercept the given request, and return a response. The given
     * {@link ClientHttpRequestExecution} allows the interceptor to pass on the
     * request and response to the next entity in the chain.
     * <p>A typical implementation of this method would follow the following pattern:
     * <ol>
     * <li>Examine the {@linkplain HttpRequest request} and body.</li>
     * <li>Optionally {@linkplain HttpRequestWrapper
     * wrap} the request to filter HTTP attributes.</li>
     * <li>Optionally modify the body of the request.</li>
     * <ul>
     * <li><strong>Either</strong>
     * <li>execute the request using
     * {@link ClientHttpRequestExecution#execute(HttpRequest, byte[])},</li>
     * <li><strong>or</strong></li>
     * <li>do not execute the request to block the execution altogether.</li>
     * </ul>
     * <li>Optionally wrap the response to filter HTTP attributes.</li>
     * </ol>
     * <p>Note: if the interceptor throws an exception after receiving a response,
     * it must close the response via {@link ClientHttpResponse#close()}.
     *
     * @param request   the request, containing method, URI, and headers
     * @param body      the body of the request
     * @param execution the request execution
     * @return the response
     * @throws IOException in case of I/O errors
     */
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        return null;
    }
}
