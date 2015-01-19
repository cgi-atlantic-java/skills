package org.guppy4j.html;

/**
 * TODO: Document this!
 */
public class Attribute {

    private final String name;
    private final Object value;

    public static Attribute attr(String name, Object value) {
        return new Attribute(name, value);
    }

    public Attribute(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
