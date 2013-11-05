package com.cgi.skills.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Skill level (relative to 100 being "perfect")
 */
@Entity
public class SkillLevel extends NamedIdHolder {

    @Column(unique = true)
    private int percent;

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
}
