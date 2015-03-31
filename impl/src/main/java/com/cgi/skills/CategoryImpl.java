package com.cgi.skills;

/**
 * Default category implementation
 */
public final class CategoryImpl implements Category {

    private final String name;
    private final Iterable<Category> subCategories;
    private final Iterable<String> skillNames;

    public CategoryImpl(String name,
                        Iterable<Category> subCategories,
                        Iterable<String> skillNames) {
        this.name = name;
        this.subCategories = subCategories;
        this.skillNames = skillNames;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Iterable<Category> subCategories() {
        return subCategories;
    }

    @Override
    public Iterable<String> skillNames() {
        return skillNames;
    }
}
