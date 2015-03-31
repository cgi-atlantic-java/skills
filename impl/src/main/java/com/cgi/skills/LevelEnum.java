package com.cgi.skills;

/**
 * Known and used skill levels at CGI and
 * in many parts of wider the IT industry
 */
public enum LevelEnum implements Level {

    Beginner(25),
    Intermediate(50),
    Expert(75);

    private final int n;

    LevelEnum(int n) {
        this.n = n;
    }

    @Override
    public int percent() {
        return n;
    }
}
