package proyVentas_Motos.beans;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;



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
	@OneToMany(mappedBy="tbCategoria")
	private List<Producto> tbProductos;

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

	public List<Producto> getTbProductos() {
		return this.tbProductos;
	}

	public void setTbProductos(List<Producto> tbProductos) {
		this.tbProductos = tbProductos;
	}

	public Producto addTbProducto(Producto tbProducto) {
		getTbProductos().add(tbProducto);
		tbProducto.setTbCategoria(this);

		return tbProducto;
	}

	public Producto removeTbProducto(Producto tbProducto) {
		getTbProductos().remove(tbProducto);
		tbProducto.setTbCategoria(null);

		return tbProducto;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj)
	        return true;
	    if (obj == null)
	        return false;
	    if (!(obj instanceof Categoria))
	        return false;
	    if(this.idCategoria == ((Categoria)obj).idCategoria)
	    	return true;
	    return false;
	}

}