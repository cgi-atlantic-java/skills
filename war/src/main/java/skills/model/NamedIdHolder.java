package skills.model;

import skills.model.interfaces.NamedIdentified;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Base class for all entity types
 */
@MappedSuperclass
public class NamedIdHolder extends IdHolder implements NamedIdentified {

    @Column(unique = true, nullable = false)
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public final String toString() {
        return name;
    }

    @Override
    public final int hashCode() {
        return name.hashCode();
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final NamedIdHolder other = (NamedIdHolder) obj;
        return name == null ? other.name == null : name.equals(other.name);
    }


}