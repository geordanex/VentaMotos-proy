package proyVentas_Motos.beans;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the tb_detalleventa database table.
 * 
 */
@Entity
@Table(name="tb_detalleventa")
@NamedQuery(name="Detalleventa.findAll", query="SELECT d FROM Detalleventa d")
public class Detalleventa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalleVenta;

	private int cantidad;

	private BigDecimal precio_Unitario;

	private BigDecimal total;

	//bi-directional many-to-one association to Venta
	@ManyToOne
	@JoinColumn(name="IdVenta")
	private Venta tbVenta;

	public Detalleventa() {
	}

	public int getIdDetalleVenta() {
		return this.idDetalleVenta;
	}

	public void setIdDetalleVenta(int idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecio_Unitario() {
		return this.precio_Unitario;
	}

	public void setPrecio_Unitario(BigDecimal precio_Unitario) {
		this.precio_Unitario = precio_Unitario;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Venta getTbVenta() {
		return this.tbVenta;
	}

	public void setTbVenta(Venta tbVenta) {
		this.tbVenta = tbVenta;
	}

}