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

import proyVentas_Motos.beans.Proveedor;

@ManagedBean
@RequestScoped
public class GestionProveedorController {
	EntityManagerFactory emf;
	EntityManager em;
	
	private List<Proveedor> proveedores;
	
	Proveedor proveedor;
	
	boolean editar;
	
	//Constructor
	public GestionProveedorController(){
		//Carga el jpa
		emf = Persistence.createEntityManagerFactory("proyVentas_Motos");
		em = emf.createEntityManager();
		
		//Se inicializa en nuevo estado
		nuevo();
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
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
				em.merge(proveedor);
			else
				em.persist(proveedor);
			
			em.getTransaction().commit();
			nuevo();
			mensaje = "Se ha ingresado el Empleado correctamente.";
				
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
		proveedor = new Proveedor();
		editar = false;
	}
	public void editar(Proveedor proveedorModificar){
		proveedor = proveedorModificar;
		editar = true;
	}
	
	

}
