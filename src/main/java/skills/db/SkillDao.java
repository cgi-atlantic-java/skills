package skills.db;

import skills.model.Skill;
import skills.model.SkillArea;
import skills.model.SkillLevel;
import skills.model.Skill_;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Database access to skill data
 */
public class SkillDao {

    public static Skill getSkill(EntityManager em, SkillArea area, SkillLevel level) {
        final List<Skill> result = getSkills(em, area, level);
        final Skill skill = result.isEmpty() ? new Skill(area, level) : result.get(0);
        skill.setLevel(level);
        em.persist(skill);
        return skill;
    }

    public static List<Skill> getSkills(EntityManager em, SkillArea area, SkillLevel level) {
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<Skill> c = cb.createQuery(Skill.class);
        final Root<Skill> ski = c.from(Skill.class);

        c.select(ski).where(
                cb.equal(ski.get(Skill_.area), area),
                cb.equal(ski.get(Skill_.level), level));

        return em.createQuery(c).getResultList();
    }
}
