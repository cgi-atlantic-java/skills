package com.cgi.skills;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.cgi.skills.LevelEnum.Intermediate;
import static com.cgi.skills.RootCategories.JAVA_DEVELOPER;

/**
 * TODO: Document this!
 */
public class RenderTest {

    @Test
    public void test() throws IOException {
        final Profile profile = profile("oliver.doepner");

        final StringBuilder sb = new StringBuilder();

        new Renderer(sb).html(JAVA_DEVELOPER, profile);

        System.out.print(sb.toString());

    }

    private Profile profile(String name) {
        final Map<String, Level> map = new HashMap<>();
        map.put("JPA", Intermediate);
        return new MapProfile(name, map);
    }
}
