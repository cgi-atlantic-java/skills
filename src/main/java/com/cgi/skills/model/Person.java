package com.cgi.skills.model;

import javax.persistence.Entity;

/**
 * TODO: Document this
 */
@Entity
public class Person {

    private String employeeId;
    private String externalEmail;
    private String externalPhone;

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
}
