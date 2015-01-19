package skills.db;

import skills.model.Person;

import javax.persistence.EntityManager;

public class PersonDao {

    public Person getPerson(String login, EntityManager em) {

        // check if person exists as persisted JPA entity
        final Person existingPerson = em.find(Person.class, login);
        if (existingPerson != null) {
            return existingPerson;
        } else {
            // otherwise create and save a Person entity
            // for the current user (based on request)
            final Person newPerson = new Person();
            newPerson.setLogin(login);
            em.persist(newPerson);
            return newPerson;
        }
    }

}
