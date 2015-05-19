package com.cgi.skills;

import org.guppy4j.http.Request;
import org.guppy4j.http.RequestHandler;
import org.guppy4j.http.Resources;
import org.guppy4j.http.Response;
import org.guppy4j.log.Log;
import org.guppy4j.log.LogProvider;

import java.io.IOException;
import java.io.Writer;

import static org.guppy4j.log.Log.Level.error;

/**
 * Main HTTP resource handler
 */
public final class RequestHandlerImpl implements RequestHandler {

    private final Log log;

    private final Resources resources;

    public RequestHandlerImpl(LogProvider logProvider,
                              Resources resources) {
        this.resources = resources;
        log = logProvider.getLog(getClass());
    }

    @Override
    public Response handle(Request request) {
        final Response response = request.startBlockingResponse();

        try (final Writer writer = response.writer("text/plain")) {

            // TODO: Remove this temporary debug code when done
            request.appendTo(writer);

            // and generated resource content
            // => call into business resource interface
            // 1) by HTTP method and HTTP method hint (in params)

//            final Resource<resources.get(hse.getRequestPath());

        } catch (IOException e) {
            log.as(error, e);
        } finally {
            response.done();
        }
        return response;
    }
}
