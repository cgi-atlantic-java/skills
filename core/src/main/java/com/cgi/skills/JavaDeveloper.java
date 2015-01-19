package com.cgi.skills;

import static com.cgi.skills.Schema.x;

/**
 * TODO: Document this!
 */
public class JavaDeveloper {

    public static final Category SCHEMA =
            x("Java Developer",
                    x("Java Language",
                            "Generics", "Enums", "Threads", "Serialization"),
                    x("JSE",
                            "Collections", "Date/Time"),
                    x("JEE",
                            x("Persistence",
                                    "JPA", "JDBC", "JTA", "JDO"))
            );
}
