package model;

import java.io.Serializable;

/**
 *
 * @author diego
 */
public class TypeAnimal implements Serializable {
    
    private long id;
    private String type;

    public TypeAnimal(long id, String type) {
        this.id = id;
        this.type = type;
    }

    public TypeAnimal() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TypeAnimal other = (TypeAnimal) obj;
        return this.id == other.id;
    }
    
}
