package skills.model;

import javax.persistence.*;

/**
 * A skill is a level of expertise in a certain area
 */
@Entity
@Table(uniqueConstraints =
@UniqueConstraint(columnNames = {Skill.AREA_ID, Skill.LEVEL_ID}))
public class Skill extends IdHolder implements Comparable<Skill> {

    static final String AREA_ID = "area_id";
    static final String LEVEL_ID = "level_id";

    @ManyToOne
    @JoinColumn(name = AREA_ID)
    private SkillArea area;

    @ManyToOne
    @JoinColumn(name = LEVEL_ID)
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
    public final int compareTo(Skill other) {
        return area.getName().compareTo(other.area.getName());
    }
}
