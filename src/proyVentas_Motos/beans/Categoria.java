package proyVentas_Motos.beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_categoria database table.
 * 
 */
@Entity
@Table(name="tb_categoria")
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCategoria;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="IdProducto")
	private Producto tbProducto;

	public Categoria() {
	}

	public int getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Producto getTbProducto() {
		return this.tbProducto;
	}

	public void setTbProducto(Producto tbProducto) {
		this.tbProducto = tbProducto;
	}

}