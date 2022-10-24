package dao;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import model.Appointment;

/**
 *
 * @author diego
 */
public class AppointmentDAO implements Serializable {

    Set<Appointment> appointments;

    public AppointmentDAO() {
        appointments = new HashSet<>();
    }

    public void add(Appointment appointment) {
        appointments.add(appointment);
    }

    public void remove(Appointment appointment) {
        appointments.remove(appointment);
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Appointment findById(long id) {
        for (Appointment appointment : appointments) {
            if (appointment.getId() == id) {
                return appointment;
            }
        }
        return null;
    }
}
