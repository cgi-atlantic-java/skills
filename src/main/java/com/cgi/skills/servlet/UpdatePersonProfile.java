package com.cgi.skills.servlet;

import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

import com.cgi.skills.model.Person;
import com.cgi.skills.model.Skill;
import com.cgi.skills.model.SkillArea;
import com.cgi.skills.model.SkillLevel;
import com.cgi.skills.model.meta.Skill_;

public class UpdatePersonProfile implements EntityProcessor<Person> {

    @Override
    public void process(HttpServletRequest request, EntityManager em, Person person) {
        final Set<Skill> skills = new HashSet<Skill>();

        for (Entry<String, String[]> param : request.getParameterMap().entrySet()) {

            final String key = param.getKey();
            final String val = param.getValue()[0];

            if ("submit".equals(key)) {
                continue;
            }

            System.out.println(key + "=" + val);

            final Long skillAreaId = convert(key);
            final Long skillLevelId = convert(val);

            if (skillLevelId != null) {

                final SkillArea area = em.find(SkillArea.class, skillAreaId);
                final SkillLevel level = em.find(SkillLevel.class, skillLevelId);

                final CriteriaBuilder cb = em.getCriteriaBuilder();
                final CriteriaQuery<Skill> c = cb.createQuery(Skill.class);
                final Root<Skill> ski = c.from(Skill.class);

                c.select(ski).where(
                        cb.equal(ski.get(Skill_.area), area),
                        cb.equal(ski.get(Skill_.level), level));

                final List<Skill> result = em.createQuery(c).getResultList();

                if (result.isEmpty()) {
                    skills.add(new Skill(area, level));
                } else {
                    final Skill skill = result.get(0);
                    skill.setLevel(level);
                    skills.add(skill);
                    em.persist(skill);
                }
                System.out.println(skillAreaId + " stands for " + area);
            }
        }

        person.setSkills(skills);
        em.persist(person);
    }

    private static Long convert(final String val) {
        return val == null || val.isEmpty() ? null : Long.valueOf(val);
    }

}
