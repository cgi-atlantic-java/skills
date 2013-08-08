package com.cgi.skills.model;

import javax.persistence.Entity;

/**
 * Classifies skill areas and should be orthogonal to category and type.
 * The concrete semantics depend on your skill domain.
 * <p/>
 * Often this would be a standards body, vendor or another similarly well-defined
 * sub-domain of the skills domain.
 */
@Entity
public class Origin extends Named {

    // no further members at this time

}
