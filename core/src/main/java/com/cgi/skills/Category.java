package com.cgi.skills;

/**
 * A skill category
 */
public interface Category {

    String getName();

    Iterable<Category> getSubCategories();

    Iterable<String> getSkillNames();
}
