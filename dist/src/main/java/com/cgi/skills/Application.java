package com.cgi.skills;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.handlers.resource.ClassPathResourceManager;
import io.undertow.server.handlers.resource.ResourceHandler;
import org.guppy4j.http.ResourcesMap;
import org.guppy4j.http.UndertowAdapter;
import org.guppy4j.io.PathHelper;
import org.guppy4j.io.StdPathHelper;
import org.guppy4j.log.Log;
import org.guppy4j.log.LogProvider;
import org.guppy4j.log.Slf4jLogProvider;

import java.nio.file.Path;
import java.nio.file.Paths;

import static io.undertow.Handlers.resource;
import static java.lang.Runtime.getRuntime;
import static java.lang.Thread.setDefaultUncaughtExceptionHandler;
import static org.guppy4j.log.Log.Level.error;
import static org.guppy4j.log.Log.Level.info;
import static org.guppy4j.log.Log.Level.warn;

/**
 * The 'Skills' application class that creates and injects all components
 * and starts the HTTP server
 */
public final class Application {

    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 8080;

    private static final String APP_NAME = "Skills";

    private final Log log;

    private final Undertow server;


    public Application() {

        final LogProvider logProvider = new Slf4jLogProvider();
        log = logProvider.getLog(getClass());

        final Path homeDir = Paths.get(System.getProperty("user.home"));

        final ResourceHandler fileHandler = resource(new ClassPathResourceManager(
                getClass().getClassLoader(), getClass().getPackage()));

        final RequestHandlerImpl requestHandler =
                new RequestHandlerImpl(logProvider, new ResourcesMap());

        final HttpHandler httpHandler =
                new UndertowAdapter(requestHandler, fileHandler, "file");

        server = Undertow.builder()
                .addHttpListener(DEFAULT_PORT, DEFAULT_HOST)
                .setHandler(httpHandler)
                .build();

        setShutdownHandlers();

        final PathHelper pathHelper =
                new StdPathHelper(APP_NAME, homeDir, logProvider);

    }

    private void setShutdownHandlers() {
        setDefaultUncaughtExceptionHandler((t, e) -> {
            log.as(error, e, "Uncaught exception occurred");
            stop();
        });
        getRuntime().addShutdownHook(new Thread(() -> {
            log.as(warn, "Application '{}': shutdown in progress.", APP_NAME);
            stop();
        }));
    }

    public void start() {
        server.start();
        logServerAction("started");
    }

    private void stop() {
        log.as(warn, "Stopping HTTP server: {}", server);
        server.stop();
        logServerAction("stopped");
    }

    private void logServerAction(String didSomethingTo) {
        log.as(info, "Successfully " + didSomethingTo + " HTTP server: {}", server);
    }
}