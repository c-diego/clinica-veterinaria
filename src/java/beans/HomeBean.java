package beans;

import dao.AppointmentDAO;
import dao.TypeAnimalDAO;
import dao.VetDAO;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import model.Appointment;
import model.TypeAnimal;
import model.Vet;

/**
 *
 * @author diego
 */
@Named(value = "homeBean")
@SessionScoped
public class HomeBean implements Serializable {

    @Inject
    TypeAnimalDAO typeAnimalDAO;

    @Inject
    VetDAO vetDAO;
    
    @Inject
    AppointmentDAO appointmentDAO;

    private TypeAnimal selectedTypeAnimal;
    private Vet selectedVet;
    private Appointment appointment;
    private boolean editing;

    public HomeBean() {
    }
    
    @PostConstruct
    public void init() {
        appointment = new Appointment();
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Vet getSelectedVet() {
        return selectedVet;
    }

    public void setSelectedVet(Vet selectedVet) {
        this.selectedVet = selectedVet;
    }

    public List<TypeAnimal> getTypeAnimals() {
        return typeAnimalDAO.getTypeAnimals();
    }

    public TypeAnimal getSelectedTypeAnimal() {
        return selectedTypeAnimal;
    }

    public void setSelectedTypeAnimal(TypeAnimal selectedTypeAnimal) {
        this.selectedTypeAnimal = selectedTypeAnimal;
    }

    public List<SelectItem> getVetItens() {
        if (selectedTypeAnimal == null) {
            return new LinkedList<>();
        }
        LinkedList<SelectItem> itens = new LinkedList<>();
        for (Vet vet : vetDAO.getVets()) {
            for (TypeAnimal tpAnimal : vet.getTypeAnimals()) {
                if (tpAnimal.getId() == selectedTypeAnimal.getId()) {
                    itens.add(new SelectItem(vet, vet.getFullName()));
                    break;
                }
            }
        }
        return itens;
    }

    public String ok() {
        if (!editing) {
        appointment.setTypeAnimal(selectedTypeAnimal);
        appointment.setVet(selectedVet);
        appointmentDAO.add(appointment);
        appointment = new Appointment();
        return null;
        }
        
        editing = false;
        appointment = new Appointment();
        return null;
    }
    
    public Set<Appointment> getAppointments() {
        return appointmentDAO.getAppointments();
    }
    
    public String delete(Appointment app) {
        appointmentDAO.remove(app);
        System.out.println("entrou");
        return null;
    }
    
    public String update(Appointment app) {
        editing = true;
        appointment = app;
        return null;
    }
}
