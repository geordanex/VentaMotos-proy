package proyVentas_Motos.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_empleado database table.
 * 
 */
@Entity
@Table(name="tb_empleado")
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idEmpleado;

	private String apellidos;

	private String cargo;

	private String nombre;

	private String sexo;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tbEmpleado")
	private List<Usuario> tbUsuarios;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="tbEmpleado")
	private List<Venta> tbVentas;

	public Empleado() {
	}

	public int getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public List<Usuario> getTbUsuarios() {
		return this.tbUsuarios;
	}

	public void setTbUsuarios(List<Usuario> tbUsuarios) {
		this.tbUsuarios = tbUsuarios;
	}

	public Usuario addTbUsuario(Usuario tbUsuario) {
		getTbUsuarios().add(tbUsuario);
		tbUsuario.setTbEmpleado(this);

		return tbUsuario;
	}

	public Usuario removeTbUsuario(Usuario tbUsuario) {
		getTbUsuarios().remove(tbUsuario);
		tbUsuario.setTbEmpleado(null);

		return tbUsuario;
	}

	public List<Venta> getTbVentas() {
		return this.tbVentas;
	}

	public void setTbVentas(List<Venta> tbVentas) {
		this.tbVentas = tbVentas;
	}

	public Venta addTbVenta(Venta tbVenta) {
		getTbVentas().add(tbVenta);
		tbVenta.setTbEmpleado(this);

		return tbVenta;
	}

	public Venta removeTbVenta(Venta tbVenta) {
		getTbVentas().remove(tbVenta);
		tbVenta.setTbEmpleado(null);

		return tbVenta;
	}

}