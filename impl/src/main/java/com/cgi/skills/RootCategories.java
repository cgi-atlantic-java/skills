package com.cgi.skills;

import static com.cgi.skills.Categories.x;

/**
 * Job profile schemas
 */
public final class RootCategories {

    public static final Category JAVA_DEVELOPER = x("Java Developer",
            x("Java Language",
                    "Generics", "Enums", "Threads", "Serialization"),
            x("JSE",
                    "Collections", "Date/Time"),
            x("JEE",
                    x("Persistence",
                            "JPA", "JDBC", "JTA", "JDO"))
    );
}
