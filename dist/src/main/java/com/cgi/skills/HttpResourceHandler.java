package com.cgi.skills;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.handlers.resource.ResourceHandler;
import io.undertow.util.Headers;
import org.guppy4j.log.Log;
import org.guppy4j.log.LogProvider;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

import static org.guppy4j.log.Log.Level.error;

/**
 * Main HTTP resource handler
 */
public final class HttpResourceHandler implements HttpHandler {

    private static final char NEWLINE = '\n';
    private static final Charset UTF8 = Charset.forName("UTF-8");

    private final Log log;
    private final ResourceHandler fileHandler;

    public HttpResourceHandler(LogProvider logProvider,
                               ResourceHandler fileHandler) {
        this.fileHandler = fileHandler;
        log = logProvider.getLog(getClass());
    }


    @Override
    public void handleRequest(HttpServerExchange hse) {

        if (hse.getRelativePath().startsWith("/file/")) {
            // distinguish between file resource
            // => serve the file
            try {
                fileHandler.handleRequest(hse);
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        } else {
            // and generated resource content
            // => call into business resource interface
            // 1) by HTTP method and HTTP method hint (in params)

            // TODO: Remove this temporary debug code when done

            hse.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
            hse.startBlocking();
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(hse.getOutputStream(), UTF8))) {
                writer
                        .append("DEBUG INFO").append(NEWLINE)
                        .append(val("requestURI", hse.getRequestURI())).append(NEWLINE)
                        .append(val("relativePath", hse.getRelativePath())).append(NEWLINE)
                        .append(val("requestPath", hse.getRequestPath())).append(NEWLINE)
                        .append(val("queryString", hse.getQueryString())).append(NEWLINE)
                ;
            } catch (IOException e) {
                log.as(error, e);
            } finally {
                hse.endExchange();
            }
        }
    }

    private static CharSequence val(String name, String value) {
        return name + " = " + value;
    }
}
