package proyVentas_Motos.utils.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import proyVentas_Motos.beans.Categoria;

@FacesConverter("CategoriaConverter")
public class CategoriaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		// TODO Auto-generated method stub
		
		if(arg2 != null && arg2.isEmpty())
			return null;
		EntityManagerFactory emf;
		EntityManager em;
		
		emf = Persistence.createEntityManagerFactory("proyVentas_Motos");
		em = emf.createEntityManager();
		
		Categoria cat = em.find(Categoria.class, Integer.parseInt(arg2));
		em.close();
		return cat;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		if(arg2==null)
			return "";
		if(arg2 instanceof Categoria){
			Categoria cat = (Categoria) arg2;
			if(cat.getIdCategoria()<=0)
				return "";
			return String.valueOf(cat.getIdCategoria());
		}
		return "";
	}

}
