package dao;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import model.TypeAnimal;

/**
 *
 * @author diego
 */
public class TypeAnimalDAO implements Serializable {
    
    private List<TypeAnimal> typeAnimals;
    
    public TypeAnimalDAO() {
        typeAnimals = new LinkedList<>();
        typeAnimals.add(new TypeAnimal(1L, "Cachorro"));
        typeAnimals.add(new TypeAnimal(2L, "Gato"));
        typeAnimals.add(new TypeAnimal(3L, "Cavalo"));
    }

    public List<TypeAnimal> getTypeAnimals() {
        return typeAnimals;
    }

    public void setTypeAnimals(List<TypeAnimal> typeAnimals) {
        this.typeAnimals = typeAnimals;
    }
    
    public TypeAnimal findById(long id) {
        for (TypeAnimal typeAnimal : typeAnimals) {
            if (typeAnimal.getId() == id) return typeAnimal;
        }
        return null;
    }
}
