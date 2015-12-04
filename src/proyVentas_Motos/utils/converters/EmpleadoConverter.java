package proyVentas_Motos.utils.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import proyVentas_Motos.beans.Empleado;

@FacesConverter("EmpleadoConverter")
public class EmpleadoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		// TODO Auto-generated method stub
		if(arg2 != null && arg2.isEmpty())
			return null;
		EntityManagerFactory emf;
		EntityManager em;
		
		emf = Persistence.createEntityManagerFactory("proyVentas_Motos");
		em = emf.createEntityManager();
		
		Empleado emp = em.find(Empleado.class, Integer.parseInt(arg2));
		em.close();
		return emp;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		if(arg2==null)
			return "";
		if(arg2 instanceof Empleado){
			Empleado emp = (Empleado) arg2;
			if(emp.getIdEmpleado()<=0)
				return "";
			return String.valueOf(emp.getIdEmpleado());
		}
		return "";
	}

}
