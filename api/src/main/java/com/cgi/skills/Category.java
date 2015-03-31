package com.cgi.skills;

/**
 * A skill category
 */
public interface Category {

    String name();

    Iterable<String> skillNames();

    Iterable<Category> subCategories();
}
