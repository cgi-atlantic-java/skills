package skills.model.interfaces;

import skills.model.Skill;

import java.util.Set;

/**
 * Something that possesses or defines a set of skills (e.g. what a person,
 * group or business unit provides or what a project, client or person needs)
 */
public interface SkillProfile extends Named {

    /**
     * @return The set of skills
     */
    Set<Skill> getSkills();

}
