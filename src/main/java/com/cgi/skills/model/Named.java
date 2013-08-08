package com.cgi.skills.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.cgi.skills.beans.Option;

/**
 * Base class for all entity types
 */
@MappedSuperclass
public class Named extends Identified implements Option {

    @Column(unique = true, nullable = false)
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Named other = (Named) obj;
        return name == null ? other.name == null : name.equals(other.name);
    }


}