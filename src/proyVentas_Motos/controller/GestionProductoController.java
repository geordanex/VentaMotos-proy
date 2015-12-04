package proyVentas_Motos.controller;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;




import proyVentas_Motos.beans.Empleado;
import proyVentas_Motos.beans.Producto;

@ManagedBean
@RequestScoped
public class GestionProductoController {
	EntityManagerFactory emf;
	EntityManager em;
	
	private List<Producto> productos;
	
	Producto producto;
	
	boolean editar;
	
	//Constructor
	public GestionProductoController(){
		//Carga el jpa
		emf = Persistence.createEntityManagerFactory("proyVentas_Motos");
		em = emf.createEntityManager();
		
		//Se inicializa en nuevo estado
		nuevo();
	}
	
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}
	
	public void guardar(){
		String mensaje = null;
		
		try{
			em.getTransaction().begin();
			if(editar)
				em.merge(producto);
			else
				em.persist(producto);
			
			em.getTransaction().commit();
			nuevo();
			mensaje = "Se ha ingresado el Producto correctamente.";
				
		}catch(Exception e){
			mensaje = "Hubo un error :(";
			e.printStackTrace();
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(mensaje));
	}
	public void nuevo(){
		producto = new Producto();
		editar = false;
	}
	
	public void editar(Producto productoModificar){
		producto = productoModificar;
		editar = true;
	}

}
