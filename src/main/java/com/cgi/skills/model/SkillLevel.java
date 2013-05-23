package com.cgi.skills.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * TODO: Document this
 */
@Entity
public class SkillLevel extends Base {

    @Column(unique = true)
    private int percent;

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
}
