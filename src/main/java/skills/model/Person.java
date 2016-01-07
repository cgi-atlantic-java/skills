package skills.model;

import skills.model.interfaces.SkillProfile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;


/**
 * A person who can have skills
 */
@Entity
public class Person implements SkillProfile {

    @Id
    private String login;

    @Column(unique = true)
    private String externalEmail;

    private String externalPhone;

    @ManyToMany
    private Set<Skill> skills = new HashSet<>();

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getExternalEmail() {
        return externalEmail;
    }

    public void setExternalEmail(String externalEmail) {
        this.externalEmail = externalEmail;
    }

    public String getExternalPhone() {
        return externalPhone;
    }

    public void setExternalPhone(String externalPhone) {
        this.externalPhone = externalPhone;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public Set<Skill> getSkills() {
        return skills;
    }

    @Override
    public String getName() {
        return login;
    }
}
