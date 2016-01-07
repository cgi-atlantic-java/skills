package skills.beans;

import skills.model.*;

import java.util.List;

/**
 * TODO: Document this
 */
public interface IProfile {

    List<Skill> getSkills(Category category, SkillType type, Origin origin);

    SkillLevel getSkillLevel(SkillArea area);

    String getName();
}
