package com.cgi.skills;

import java.util.Map;

import static java.util.Collections.unmodifiableMap;

/**
 * In-memory skills profile using a simple map
 */
public final class MapProfile implements Profile {

    private final Map<String, Level> skillLevels;
    private final String name;

    public MapProfile(String name, Map<String, Level> skillLevels) {
        this.name = name;
        this.skillLevels = unmodifiableMap(skillLevels);
    }

    @Override
    public Level level(String skillName) {
        return skillLevels.get(skillName);
    }

    @Override
    public String name() {
        return name;
    }
}
