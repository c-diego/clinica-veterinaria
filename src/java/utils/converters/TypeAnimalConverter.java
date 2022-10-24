package utils.converters;

import dao.TypeAnimalDAO;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import model.TypeAnimal;

/**
 *
 * @author diego
 */
@ApplicationScoped
@Named(value = "typeAnimalConverter")
public class TypeAnimalConverter implements Converter {

    @Inject
    TypeAnimalDAO typeAnimalDao;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {

            TypeAnimal typeAnimal = (TypeAnimal) value;
            return String.valueOf(typeAnimal.getId());
        }

        return null;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        try {
            
            long id = Long.parseLong(value);
            return typeAnimalDao.findById(id);
        
        } catch (NumberFormatException nfe) {}
        return null;
    }

}
