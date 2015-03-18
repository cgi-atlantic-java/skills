package com.cgi.skills;

/**
 * A simple String name wrapper
 */
public final class SimpleName implements Name {

    private final String s;

    public SimpleName(String s) {
        this.s = s;
    }

    @Override
    public String get() {
        return s;
    }
}
