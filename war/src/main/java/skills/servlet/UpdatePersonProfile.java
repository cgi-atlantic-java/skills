package skills.servlet;

import skills.model.Person;
import skills.model.Skill;
import skills.model.SkillArea;
import skills.model.SkillLevel;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import static skills.db.SkillDao.getSkill;

public final class UpdatePersonProfile implements EntityProcessor<Person> {

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
                skills.add(getSkill(em, area, level));

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
