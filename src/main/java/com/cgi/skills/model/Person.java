package com.cgi.skills.model;

import javax.persistence.Entity;

/**
 * TODO: Document this
 */
@Entity
public class Person {

    private String employeeId;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
