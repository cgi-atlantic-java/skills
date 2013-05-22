package com.cgi.skills.model;

import javax.persistence.Entity;

/**
 * TODO: Document this
 */
@Entity
public class Person {

    private String employeeId;
    private String externalEmail;

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
}
