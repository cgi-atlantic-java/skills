package skills.beans;

import skills.model.Category;
import skills.model.Origin;
import skills.model.Skill;
import skills.model.SkillArea;
import skills.model.SkillLevel;
import skills.model.SkillType;

import java.util.List;

/**
 * TODO: Document this
 */
public interface IProfile {

    List<Skill> getSkills(Category category, SkillType type, Origin origin);

    SkillLevel getSkillLevel(SkillArea area);

    String getName();
}
