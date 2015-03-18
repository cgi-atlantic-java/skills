package com.cgi.skills;

/**
 * TODO: Document this!
 */
public final class SkillsResourceTest {

    private final Name name = new SimpleName("oliver.doepner");
    private final SkillsResource resource = new SkillsResource();

    public void testGet() {
        resource.get(name);
    }

}
