package proyVentas_Motos.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the tb_producto database table.
 * 
 */
@Entity
@Table(name="tb_producto")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idProducto;

	private String nombre;

	private BigDecimal precio;

	private String proveedor;

	private int stock;

	//bi-directional many-to-one association to Categoria
	@OneToMany(mappedBy="tbProducto")
	private List<Categoria> tbCategorias;

	//bi-directional many-to-one association to Comentario
	@OneToMany(mappedBy="tbProducto")
	private List<Comentario> tbComentarios;

	//bi-directional many-to-one association to Proveedor
	@ManyToOne
	@JoinColumn(name="IdProveedor")
	private Proveedor tbProveedor;

	public Producto() {
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<Categoria> getTbCategorias() {
		return this.tbCategorias;
	}

	public void setTbCategorias(List<Categoria> tbCategorias) {
		this.tbCategorias = tbCategorias;
	}

	public Categoria addTbCategoria(Categoria tbCategoria) {
		getTbCategorias().add(tbCategoria);
		tbCategoria.setTbProducto(this);

		return tbCategoria;
	}

	public Categoria removeTbCategoria(Categoria tbCategoria) {
		getTbCategorias().remove(tbCategoria);
		tbCategoria.setTbProducto(null);

		return tbCategoria;
	}

	public List<Comentario> getTbComentarios() {
		return this.tbComentarios;
	}

	public void setTbComentarios(List<Comentario> tbComentarios) {
		this.tbComentarios = tbComentarios;
	}

	public Comentario addTbComentario(Comentario tbComentario) {
		getTbComentarios().add(tbComentario);
		tbComentario.setTbProducto(this);

		return tbComentario;
	}

	public Comentario removeTbComentario(Comentario tbComentario) {
		getTbComentarios().remove(tbComentario);
		tbComentario.setTbProducto(null);

		return tbComentario;
	}

	public Proveedor getTbProveedor() {
		return this.tbProveedor;
	}

	public void setTbProveedor(Proveedor tbProveedor) {
		this.tbProveedor = tbProveedor;
	}

}