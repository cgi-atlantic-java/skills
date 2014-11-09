package com.cgi.skills.db;

import com.cgi.skills.model.Category;
import com.cgi.skills.model.NamedIdHolder;
import com.cgi.skills.model.Origin;
import com.cgi.skills.model.Person;
import com.cgi.skills.model.Skill;
import com.cgi.skills.model.SkillArea;
import com.cgi.skills.model.SkillLevel;
import com.cgi.skills.model.SkillType;

import javax.persistence.EntityManager;
import java.util.HashSet;

import static com.cgi.skills.db.SkillDao.getSkill;
import static java.util.Arrays.asList;

public class DataInitializer {

    private final EntityManager em;

    public DataInitializer(EntityManager em) {
        this.em = em;
    }

    public void initData() {
        em.getTransaction().begin();
        persistEntities();
        em.getTransaction().commit();
    }

    private void persistEntities() {
        final SkillType api = persist(new SkillType(), "API");
        final SkillType tool = persist(new SkillType(), "Tool");
        final SkillType langFeature = persist(new SkillType(), "Language feature");

        final Origin jee = persist(new Origin(), "JEE");
        final Origin jse = persist(new Origin(), "JSE");
        final Origin other = persist(new Origin(), "Other");

        final Category persistence = persist(new Category(), "Persistence");
        final Category messaging = persist(new Category(), "Messaging");
        final Category managedapp = persist(new Category(), "Managed Applications");
        final Category ws = persist(new Category(), "Web Services");
        final Category xml = persist(new Category(), "XML");
        final Category ui = persist(new Category(), "UI");

        final Category ph = persist(new Category(), "PH");

        final SkillArea jpa = persist(new SkillArea(), "JPA", api, jee, persistence);
        final SkillArea jta = persist(new SkillArea(), "JTA", api, jee, persistence);

        final SkillArea jms = persist(new SkillArea(), "JMS", api, jee, messaging);
        final SkillArea javamail = persist(new SkillArea(), "JavaMail", api, jee, messaging);

        final SkillArea cdi = persist(new SkillArea(), "CDI", api, jee, managedapp);
        final SkillArea ejb = persist(new SkillArea(), "EJB", api, jee, managedapp);
        final SkillArea beanval = persist(new SkillArea(), "Bean Validation", api, jee, managedapp);

        final SkillArea jaxws = persist(new SkillArea(), "JAX-WS", api, jee, ws);
        final SkillArea jaxrs = persist(new SkillArea(), "JAX-RS", api, jee, ws);
        final SkillArea jaxb = persist(new SkillArea(), "JAXB", api, jee, ws);
        final SkillArea jaxr = persist(new SkillArea(), "JAXR", api, jee, ws);
        final SkillArea saaj = persist(new SkillArea(), "SAAJ", api, jee, ws);

        final SkillArea jsf = persist(new SkillArea(), "JSF", api, jee, ui);
        final SkillArea jsp = persist(new SkillArea(), "JSP", api, jee, ui);
        final SkillArea servlets = persist(new SkillArea(), "Servlets", api, jee, ui);
        final SkillArea facelets = persist(new SkillArea(), "Facelets", api, jee, ui);
        final SkillArea jstl = persist(new SkillArea(), "JSTL", api, jee, ui);
        final SkillArea el = persist(new SkillArea(), "Expression Language", api, jee, ui);

        final SkillArea jdbc = persist(new SkillArea(), "JDBC", api, jse, persistence);

        final SkillArea swing = persist(new SkillArea(), "Swing", api, jse, ui);

        final SkillArea jni = persist(new SkillArea(), "JNI", langFeature, jse, ph);
        final SkillArea math = persist(new SkillArea(), "Math", langFeature, jse, ph);
        final SkillArea security = persist(new SkillArea(), "Security", langFeature, jse, ph);
        final SkillArea networking = persist(new SkillArea(), "Networking", langFeature, jse, ph);
        final SkillArea intlsupport = persist(new SkillArea(), "Int'l Support", langFeature, jse, ph);
        final SkillArea serilization = persist(new SkillArea(), "Serilization", langFeature, jse, ph);
        final SkillArea inout = persist(new SkillArea(), "Input/Output", langFeature, jse, ph);
        final SkillArea beans = persist(new SkillArea(), "Beans", langFeature, jse, ph);
        final SkillArea extensionmechanism = persist(new SkillArea(), "Extension Mechanism", langFeature, jse, ph);


        final SkillArea hibernate = persist(new SkillArea(), "Hibernate", api, other, persistence);

        final SkillLevel beginner = createLevel("Beginner", 25);
        final SkillLevel intermediate = createLevel("Intermediate", 50);
        final SkillLevel expert = createLevel("Expert", 75);

        createPerson("faran.khattana",
                getSkill(em, jpa, expert),
                getSkill(em, jta, intermediate));

        createPerson("oliver.doepner",
                getSkill(em, jpa, expert),
                getSkill(em, jta, intermediate));
    }

    private void createPerson(String login, Skill... skills) {
        final Person person = new Person();
        person.setLogin(login);
        person.setSkills(new HashSet<>(asList(skills)));
        em.persist(person);
    }

    private SkillLevel createLevel(String name, int percent) {
        final SkillLevel level = new SkillLevel();
        level.setPercent(percent);
        level.setName(name);
        em.persist(level);
        return level;
    }

    private SkillArea persist(SkillArea sa, String name,
                              SkillType skillType, Origin origin,
                              Category category) {
        sa.setName(name);
        sa.setCategory(category);
        sa.setOrigin(origin);
        sa.setType(skillType);
        em.persist(sa);
        return sa;
    }

    private <T extends NamedIdHolder> T persist(T entity, String name) {
        entity.setName(name);
        em.persist(entity);
        return entity;
    }
}
