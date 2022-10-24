package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author diego
 */
public class Appointment implements Serializable {
    
    private static long sequence = 1L;
    private long id;
    private Date date;
    private Vet vet;
    private TypeAnimal typeAnimal;
    private String owner;
    private String reason;
    private String animalName;
    private String phone;

    public Appointment(long id, Date date, Vet vet, TypeAnimal typeAnimal, String owner, String reason, String animalName, String phone) {
        this.id = id;
        this.date = date;
        this.vet = vet;
        this.typeAnimal = typeAnimal;
        this.owner = owner;
        this.reason = reason;
        this.animalName = animalName;
        this.phone = phone;
    }

    public Appointment() {
        id = ++sequence;
    }

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public TypeAnimal getTypeAnimal() {
        return typeAnimal;
    }

    public void setTypeAnimal(TypeAnimal typeAnimal) {
        this.typeAnimal = typeAnimal;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Appointment other = (Appointment) obj;
        return this.id == other.id;
    }
    
    
}
