package com.cgi.skills;

/**
 * TODO: Document this!
 */
public enum Level {

    Beginner(25),
    Intermediate(50),
    Expert(75);

    private final int n;

    Level(int n) {
        this.n = n;
    }

    public int getPercent() {
        return n;
    }
}
