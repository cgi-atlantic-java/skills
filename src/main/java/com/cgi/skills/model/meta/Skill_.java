package com.cgi.skills.model.meta;

import javax.persistence.metamodel.SingularAttribute;

import com.cgi.skills.model.Skill;
import com.cgi.skills.model.SkillArea;
import com.cgi.skills.model.SkillLevel;


@javax.persistence.metamodel.StaticMetamodel(Skill.class)
public class Skill_ {

    public static volatile SingularAttribute<Skill, Long> id;
    public static volatile SingularAttribute<Skill, SkillArea> area;
    public static volatile SingularAttribute<Skill, SkillLevel> level;

}
