package com.cgi.skills;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.cgi.skills.Level.Intermediate;

/**
 * TODO: Document this!
 */
public class RenderTest {

    @Test
    public void test() throws IOException {
        final Profile profile = profile("oliver.doepner");

        final StringBuilder sb = new StringBuilder();

        new Renderer(sb).html(JavaDeveloper.SCHEMA, profile);

        System.out.print(sb.toString());

    }

    private Profile profile(String name) {
        Map<String, Level> map = new HashMap<>();
        map.put("JPA", Intermediate);
        return new MapProfile(name, map);
    }
}
