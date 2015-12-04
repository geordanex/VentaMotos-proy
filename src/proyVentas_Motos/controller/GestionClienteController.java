package proyVentas_Motos.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.primefaces.event.SelectEvent;

import proyVentas_Motos.beans.Cliente;


@ManagedBean
@RequestScoped
public class GestionClienteController {
	EntityManagerFactory emf;
	EntityManager em;
	
	private List<Cliente> clientes;
	
	Cliente cliente;
	
	boolean editar;
	
	//Constructor
	public GestionClienteController() {
		//Carga el jpa
		emf = Persistence.createEntityManagerFactory("proyVentas_Motos");
		em = emf.createEntityManager();
		
		//Se inicializa en nuevo estado
		nuevo();
	}
	public Cliente getCliente(){
		return cliente;
	}
	public void setCliente(Cliente cliente){
		this.cliente = cliente;
	}
	
	public List<Cliente> getClientes(){
		return clientes;
	}
	
	public void setClientes(List<Cliente> clientes){
		this.clientes = clientes;
	}
	public boolean isEditar(){
		return editar;
	}
	public void setEditar(boolean editar){
		this.editar = editar;
	}
	
	public void guardar(){
String mensaje = null;
		
		try{
			em.getTransaction().begin();
			if(editar)
				em.merge(cliente);
			else
				em.persist(cliente);
			
			em.getTransaction().commit();
			nuevo();
			mensaje = "Se ha ingresado el Cliente correctamente.";
				
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
		cliente = new Cliente();
		editar = false;
	}
	public void editar(Cliente clienteModificar){
		cliente = clienteModificar;
		editar = true;
	}
	public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }

}
