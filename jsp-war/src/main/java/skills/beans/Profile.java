package skills.beans;

import skills.model.Category;
import skills.model.Origin;
import skills.model.Skill;
import skills.model.SkillArea;
import skills.model.SkillLevel;
import skills.model.SkillType;
import skills.model.interfaces.SkillProfile;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * UI bean representing a skill profile
 */
public class Profile implements IProfile {

    private final SkillProfile profile;

    public Profile(SkillProfile profile) {
        this.profile = profile;
    }

    @Override
    public String getName() {
        return profile.getName();
    }

    @Override
    public List<Skill> getSkills(Category category, SkillType type, Origin origin) {
        final List<Skill> result = new LinkedList<>();

        for (Skill skill : profile.getSkills()) {
            final SkillArea area = skill.getArea();

            if (area.getCategory() == category && area.getType() == type
                    && area.getOrigin() == origin) {

                result.add(skill);
            }
        }
        Collections.sort(result);
        return result;
    }

    @Override
    public SkillLevel getSkillLevel(SkillArea area) {
        for (Skill skill : profile.getSkills()) {
            if (skill.getArea().equals(area)) {
                return skill.getLevel();
            }
        }
        return null;
    }
}
