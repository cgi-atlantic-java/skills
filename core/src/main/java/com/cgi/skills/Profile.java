package com.cgi.skills;

/**
 * TODO: Document this!
 */
public interface Profile {

    Level level(String skillName);

    String name();

    void save();
}
