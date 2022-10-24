package model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author diego
 */
public class Vet implements Serializable {
    
    private long id;
    private String fullName;
    private String phone;
    private List<TypeAnimal> typeAnimals;
    
    public Vet(long id, String fullName, String phone, List<TypeAnimal> typeAnimals) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.typeAnimals = typeAnimals;
    }

    public Vet() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<TypeAnimal> getTypeAnimals() {
        return typeAnimals;
    }

    public void setTypeAnimals(List<TypeAnimal> typeAnimals) {
        this.typeAnimals = typeAnimals;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Vet other = (Vet) obj;
        return this.id == other.id;
    }
    
}
