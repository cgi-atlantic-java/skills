package com.cgi.skills.model;

import javax.persistence.Entity;

/**
 * Classifies skill areas and should be orthogonal to category and origin.
 * The concrete semantics depend on your skill domain.
 */
@Entity
public class SkillType extends Named {

    // no further members at this time

}
