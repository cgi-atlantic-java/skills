package com.cgi.skills.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * TODO: Document this
 */
@Entity
public class Skill extends Base {

    @ManyToOne
    private Origin origin;

    @ManyToOne
    private Category category;

    @ManyToOne
    private SkillType type;

    private boolean ui;

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SkillType getType() {
        return type;
    }

    public void setType(SkillType type) {
        this.type = type;
    }

    public boolean isUi() {
        return ui;
    }

    public void setUi(boolean ui) {
        this.ui = ui;
    }
}
