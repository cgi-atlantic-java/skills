package com.cgi.skills;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

/**
 * TODO: Document this!
 */
public class Schema implements Category {

    private final String name;
    private Iterable<Category> subCategories;
    private Iterable<String> skillNames;

    public static Category x(String name, String... skillNames) {
        return new Schema(name, emptyList(), asList(skillNames));
    }

    public static Category x(String name, Category... categories) {
        return new Schema(name, asList(categories), emptyList());
    }

    public Schema(String name,
                  Iterable<Category> subCategories,
                  Iterable<String> skillNames) {
        this.name = name;
        this.subCategories = subCategories;
        this.skillNames = skillNames;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Iterable<Category> getSubCategories() {
        return subCategories;
    }

    @Override
    public Iterable<String> getSkillNames() {
        return skillNames;
    }
}
