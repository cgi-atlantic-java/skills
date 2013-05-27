package com.cgi.skills.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * TODO: Document this
 */
@Entity
public class Skill {

    @ManyToOne
    private SkillArea area;

    @ManyToOne
    private SkillLevel level;

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
}
