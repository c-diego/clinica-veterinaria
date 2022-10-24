package utils.converters;

import dao.VetDAO;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import model.Vet;

/**
 *
 * @author diego
 */
@ApplicationScoped
@Named(value = "vetConverter")
public class VetConverter implements Converter {

    @Inject
    VetDAO vetDAO;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {

            Vet vet = (Vet) value;
            return String.valueOf(vet.getId());
        }

        return null;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        try {
            
            long id = Long.parseLong(value);
            return vetDAO.findById(id);
        
        } catch (NumberFormatException nfe) {}
        return null;
    }

}
