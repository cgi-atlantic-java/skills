package com.cgi.skills.beans;

import com.cgi.skills.model.Category;
import com.cgi.skills.model.Origin;
import com.cgi.skills.model.Skill;
import com.cgi.skills.model.SkillArea;
import com.cgi.skills.model.SkillLevel;
import com.cgi.skills.model.SkillType;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO: Document this
 */
public class Classifications {

    private final EntityManager entityManager;

    public Classifications(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Origin> getAllOrigins() {
        return getAll(Origin.class);
    }

    public List<SkillType> getAllTypes() {
        return getAll(SkillType.class);
    }

    public List<Category> getAllCategories() {
        return getAll(Category.class);
    }

    public List<Skill> getAllSkills() {
        return getAll(Skill.class);
    }

    public List<SkillArea> getAllSkillAreas() {
        return getAll(SkillArea.class);
    }

    public List<SkillLevel> getAllLevels() {
        return getAll(SkillLevel.class);
    }

    private <T> List<T> getAll(Class<T> c) {
        final String className = c.getSimpleName();
        final Query query = entityManager.createQuery("SELECT e FROM " + className + " e");
        final List<T> result = (List<T>) query.getResultList();
        System.out.println("className:" + className);
        System.out.println("result.size():" + result.size());
        return result;
    }

    public List<SkillArea> getAllSkillAreas(Category category, SkillType type, Origin origin) {
        final List<SkillArea> result = new LinkedList<>();

        for (final SkillArea area : getAllSkillAreas()) {
            if (category.equals(area.getCategory())
                    && type.equals(area.getType())
                    && origin.equals(area.getOrigin())) {

                result.add(area);
            }

        }
        return result;
    }


}
