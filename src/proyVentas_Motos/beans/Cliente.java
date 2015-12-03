package proyVentas_Motos.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb_cliente database table.
 * 
 */
@Entity
@Table(name="tb_cliente")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCliente;

	private String apellidos;

	private String direccion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fec_Nac;

	private String nombre;

	private String num_Doc;

	private String sexo;

	private String telefono;

	private String tipo_Doc;

	//bi-directional many-to-one association to Comentario
	@OneToMany(mappedBy="tbCliente")
	private List<Comentario> tbComentarios;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tbCliente")
	private List<Usuario> tbUsuarios;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="tbCliente")
	private List<Venta> tbVentas;

	public Cliente() {
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFec_Nac() {
		return this.fec_Nac;
	}

	public void setFec_Nac(Date fec_Nac) {
		this.fec_Nac = fec_Nac;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNum_Doc() {
		return this.num_Doc;
	}

	public void setNum_Doc(String num_Doc) {
		this.num_Doc = num_Doc;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipo_Doc() {
		return this.tipo_Doc;
	}

	public void setTipo_Doc(String tipo_Doc) {
		this.tipo_Doc = tipo_Doc;
	}

	public List<Comentario> getTbComentarios() {
		return this.tbComentarios;
	}

	public void setTbComentarios(List<Comentario> tbComentarios) {
		this.tbComentarios = tbComentarios;
	}

	public Comentario addTbComentario(Comentario tbComentario) {
		getTbComentarios().add(tbComentario);
		tbComentario.setTbCliente(this);

		return tbComentario;
	}

	public Comentario removeTbComentario(Comentario tbComentario) {
		getTbComentarios().remove(tbComentario);
		tbComentario.setTbCliente(null);

		return tbComentario;
	}

	public List<Usuario> getTbUsuarios() {
		return this.tbUsuarios;
	}

	public void setTbUsuarios(List<Usuario> tbUsuarios) {
		this.tbUsuarios = tbUsuarios;
	}

	public Usuario addTbUsuario(Usuario tbUsuario) {
		getTbUsuarios().add(tbUsuario);
		tbUsuario.setTbCliente(this);

		return tbUsuario;
	}

	public Usuario removeTbUsuario(Usuario tbUsuario) {
		getTbUsuarios().remove(tbUsuario);
		tbUsuario.setTbCliente(null);

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
		tbVenta.setTbCliente(this);

		return tbVenta;
	}

	public Venta removeTbVenta(Venta tbVenta) {
		getTbVentas().remove(tbVenta);
		tbVenta.setTbCliente(null);

		return tbVenta;
	}

}