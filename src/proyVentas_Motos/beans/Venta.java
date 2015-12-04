package proyVentas_Motos.beans;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb_venta database table.
 * 
 */
@Entity
@Table(name="tb_venta")
@NamedQuery(name="Venta.findAll", query="SELECT v FROM Venta v")
public class Venta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVenta;

	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	private BigDecimal igv;

	//bi-directional many-to-one association to Detalleventa
	@OneToMany(mappedBy="tbVenta")
	private List<Detalleventa> tbDetalleventas;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="IdCliente")
	private Cliente tbCliente;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="IdEmpleado")
	private Empleado tbEmpleado;

	public Venta() {
	}

	public int getIdVenta() {
		return this.idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getIgv() {
		return this.igv;
	}

	public void setIgv(BigDecimal igv) {
		this.igv = igv;
	}

	public List<Detalleventa> getTbDetalleventas() {
		return this.tbDetalleventas;
	}

	public void setTbDetalleventas(List<Detalleventa> tbDetalleventas) {
		this.tbDetalleventas = tbDetalleventas;
	}

	public Detalleventa addTbDetalleventa(Detalleventa tbDetalleventa) {
		getTbDetalleventas().add(tbDetalleventa);
		tbDetalleventa.setTbVenta(this);

		return tbDetalleventa;
	}

	public Detalleventa removeTbDetalleventa(Detalleventa tbDetalleventa) {
		getTbDetalleventas().remove(tbDetalleventa);
		tbDetalleventa.setTbVenta(null);

		return tbDetalleventa;
	}

	public Cliente getTbCliente() {
		return this.tbCliente;
	}

	public void setTbCliente(Cliente tbCliente) {
		this.tbCliente = tbCliente;
	}

	public Empleado getTbEmpleado() {
		return this.tbEmpleado;
	}

	public void setTbEmpleado(Empleado tbEmpleado) {
		this.tbEmpleado = tbEmpleado;
	}

}