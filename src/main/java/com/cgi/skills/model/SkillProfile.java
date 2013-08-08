package com.cgi.skills.model;

import java.util.Set;

/**
 * Something that possesses or defines a set of skills (e.g. what a person,
 * group or business unit provides or what a project, client or person needs)
 */
public interface SkillProfile {

    String getName();

    Set<Skill> getSkills();

}
