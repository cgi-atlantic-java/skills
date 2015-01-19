package com.cgi.skills;

import java.util.Map;

/**
 * TODO: Document this!
 */
public class MapProfile implements Profile {

    private Map<String, Level> skillLevels;
    private final String name;

    public MapProfile(String name, Map<String, Level> skillLevels) {
        this.name = name;
        this.skillLevels = skillLevels;
    }

    @Override
    public Level level(String skillName) {
        return skillLevels.get(skillName);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void save() {

    }
}
