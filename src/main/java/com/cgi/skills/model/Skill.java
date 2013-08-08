package com.cgi.skills.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * A skill is a level or expertise in a certain area
 */
@Entity
public class Skill extends Identified implements Comparable<Skill> {

    @ManyToOne
    private SkillArea area;

    @ManyToOne
    private SkillLevel level;

    public Skill() {
        // no-args constructor required for JPA
    }

    public Skill(SkillArea area, SkillLevel level) {
        this.area = area;
        this.level = level;
    }

    public SkillArea getArea() {
        return area;
    }

    public void setArea(SkillArea area) {
        this.area = area;
    }

    public SkillLevel getLevel() {
        return level;
    }

    public void setLevel(SkillLevel level) {
        this.level = level;
    }

    @Override
    public int compareTo(Skill other) {
        return area.getName().compareTo(other.area.getName());
    }
}
