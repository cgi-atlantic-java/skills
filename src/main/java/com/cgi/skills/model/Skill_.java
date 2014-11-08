package com.cgi.skills.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(Skill.class)
public class Skill_ {

    public static volatile SingularAttribute<Skill, Long> id;
    public static volatile SingularAttribute<Skill, SkillArea> area;
    public static volatile SingularAttribute<Skill, SkillLevel> level;

}
