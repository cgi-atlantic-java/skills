package skills.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Skill area (semantics depend on your skill domain)
 */
@Entity
public class SkillArea extends NamedIdHolder {

    @ManyToOne
    private Origin origin;

    @ManyToOne
    private Category category;

    @ManyToOne
    private SkillType type;

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
}
