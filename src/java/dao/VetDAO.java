package dao;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import model.TypeAnimal;
import model.Vet;

/**
 *
 * @author diego
 */
public class VetDAO implements Serializable {
    
    private List<Vet> vets;
    
    public VetDAO() {
        vets = new LinkedList<>();
        List<TypeAnimal> lista = new LinkedList<>();
        lista.add(new TypeAnimal(1L, "Cachorro"));
        vets.add(new Vet(1L, "João Pablo", "4598887777", lista));
    }

    public List<Vet> getVets() {
        return vets;
    }

    public void setVets(List<Vet> vets) {
        this.vets = vets;
    }
    
    public Vet findById(long id) {
        for (Vet vet : vets) {
            if (vet.getId() == id) return vet;
        }
        return null;
    }
}
