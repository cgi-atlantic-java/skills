package com.cgi.skills.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * A person who can have skills
 */
@Entity
public class Person implements SkillProfile {

    @Column(unique = true)
    private String employeeId;

    @Column(unique = true)
    private String externalEmail;

    private String externalPhone;

    @OneToMany
    private Set<Skill> skills;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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
}
