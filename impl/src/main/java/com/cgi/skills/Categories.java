package com.cgi.skills;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

/**
 * Static factory methods for concise
 * category hierarchy construction
 */
public final class Categories {

    private Categories() {
        // no instances
    }

    public static Category x(String name, String... skillNames) {
        return cat(name, emptyList(), asList(skillNames));
    }

    public static Category x(String name, Category... categories) {
        return cat(name, asList(categories), emptyList());
    }

    private static Category cat(String name,
                                Iterable<Category> subCategories,
                                Iterable<String> names) {
        return new CategoryImpl(name, subCategories, names);
    }
}
