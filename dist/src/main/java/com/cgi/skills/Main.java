package com.cgi.skills;

/**
 * Starts the application
 */
public final class Main {

    private Main() {
        // no instances
    }

    /**
     * @param args currently ignored
     * @see <a href="https://github.com/undertow-io/undertow/tree/master/examples">Undertow code examples</a>
     */
    public static void main(final String[] args) {
        new Application().start();
    }
}
