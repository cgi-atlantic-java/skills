package com.cgi.skills;

import org.guppy4j.html.Attribute;

import java.io.IOException;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.guppy4j.html.Attribute.attr;

/**
 * TODO: Document this!
 */
public final class Renderer {

    private final Appendable appendable;

    public Renderer(Appendable appendable) {
        this.appendable = appendable;
    }

    public void html(Category c, Profile profile) {

        for (Category sc : c.getSubCategories()) {
            fieldset(sc, profile);
        }
        close("html");
    }

    public void fieldset(Category c, Profile profile) {
        open("fieldset");
        legend(c);
        for (Category sc : c.getSubCategories()) {
            fieldset(sc, profile);
        }
        for (String name : c.getSkillNames()) {
            label(name);
            select(name, profile.level(name));
        }
        close("fieldset");
    }

    private void legend(Category c) {
        open("legend");
        append(c.getName());
        close("legend");
    }

    private void label(String name) {
        open("label", attr("for", name));
        append(name);
        close("label");
    }

    private void select(String name, Level currentLevel) {
        open("select", attr("name", name), attr("id", name));
        option(currentLevel, null);
        for (Level level : Level.values()) {
            option(currentLevel, level);
        }
        close("select");
    }

    private void option(Level currentLevel, Level level) {
        final int value = level == null ? 0 : level.getPercent();
        open("option", attr("value", value), attr("selected", currentLevel == level));
        append(level == null ? "" : level.name());
        close("option");
    }

    private void unary(String tagName,
                       Attribute... attributes) {
        tag(tagName, true, attributes);
    }

    private void open(String tagName,
                      Attribute... attributes) {
        tag(tagName, false, attributes);
    }

    private void tag(String tagName, boolean unary,
                     Attribute... attributes) {
        append('<');
        append(tagName);
        for (final Attribute attr : attributes) {
            final String name = attr.getName();
            final Object value = attr.getValue();
            if (FALSE.equals(value)) {
                // do nothing
            } else if (TRUE.equals(value)) {
                attribute(name, name);
            } else {
                attribute(name, value.toString());
            }
        }
        if (unary) {
            append('/');
        }
        append('>');
    }

    private void attribute(String name, String valueString) {
        append(' ');
        append(name);
        append('=');
        append('"');
        append(valueString);
        append('"');
    }


    private void close(String tagName) {
        append('<').append('/').append(tagName);
        append('>');
    }

    private Renderer append(char c) {
        try {
            appendable.append(c);
        } catch (final IOException e) {
            throwWrapped(e);
        }
        return this;
    }

    private Renderer append(String s) {
        try {
            appendable.append(s);
        } catch (final IOException e) {
            throwWrapped(e);
        }
        return this;
    }

    private static void throwWrapped(IOException e) {
        throw new IllegalStateException(e);
    }
}
