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

@ManagedBean
@RequestScoped
public class GestionEmpleadoController {
	EntityManagerFactory emf;
	EntityManager em;
	
	private List<Empleado> empleados;
	
	Empleado empleado;
	
	boolean editar;
	
	//Constructor
	public GestionEmpleadoController(){
		//Carga el jpa
		emf = Persistence.createEntityManagerFactory("proyVentas_Motos");
		em = emf.createEntityManager();
		
		//Se inicializa en nuevo estado
		nuevo();
	}
	
	public Empleado getEmpleado(){
		return empleado;
	}
	public void setEmpleado(Empleado empleado){
		this.empleado = empleado;
	}
	
	public List<Empleado> getEmpleados(){
		return empleados;
	}
	
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
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
				em.merge(empleado);
			else
				em.persist(empleado);
			
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
		empleado = new Empleado();
		editar = false;
	}
	
	public void editar(Empleado empleadoModificar){
		empleado = empleadoModificar;
		editar = true;
	}

}
