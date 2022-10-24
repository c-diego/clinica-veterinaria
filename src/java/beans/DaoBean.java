package beans;

import dao.AppointmentDAO;
import dao.TypeAnimalDAO;
import dao.VetDAO;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

/**
 *
 * @author diego
 */
@Named(value = "initDAOBean")
@ApplicationScoped
public class DaoBean {

    private VetDAO vetDAO;
    private TypeAnimalDAO typeAnimalDAO;
    private AppointmentDAO appointmentDAO;

    public DaoBean() {
    }

    @Produces
    public VetDAO getVetDAO() {
        if (vetDAO != null) {
            return vetDAO;
        }

        return new VetDAO();
    }

    @Produces
    public TypeAnimalDAO getTypeAnimalDAO() {
        if (typeAnimalDAO != null) {
            return typeAnimalDAO;
        }

        return new TypeAnimalDAO();
    }

    @Produces
    public AppointmentDAO getAppointmentDAO() {
        if (appointmentDAO != null) {
            return appointmentDAO;
        }

        return new AppointmentDAO();
    }
}
