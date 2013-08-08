package com.cgi.skills.beans;

import java.util.List;

import com.cgi.skills.model.Category;
import com.cgi.skills.model.Origin;
import com.cgi.skills.model.Skill;
import com.cgi.skills.model.SkillArea;
import com.cgi.skills.model.SkillLevel;
import com.cgi.skills.model.SkillType;

/**
 * TODO: Document this
 */
public interface IProfile {

    List<Skill> getSkills(Category category, SkillType type, Origin origin);

    SkillLevel getSkillLevel(SkillArea area);

    String getName();
}
