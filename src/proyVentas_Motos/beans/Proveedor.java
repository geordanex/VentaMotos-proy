package proyVentas_Motos.beans;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the tb_proveedor database table.
 * 
 */
@Entity
@Table(name="tb_proveedor")
@NamedQuery(name="Proveedor.findAll", query="SELECT p FROM Proveedor p")
public class Proveedor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProveedor;

	private String direccion;

	private String proveedor;

	private String telefono;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="tbProveedor")
	private List<Producto> tbProductos;

	public Proveedor() {
	}

	public int getIdProveedor() {
		return this.idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Producto> getTbProductos() {
		return this.tbProductos;
	}

	public void setTbProductos(List<Producto> tbProductos) {
		this.tbProductos = tbProductos;
	}

	public Producto addTbProducto(Producto tbProducto) {
		getTbProductos().add(tbProducto);
		tbProducto.setTbProveedor(this);

		return tbProducto;
	}

	public Producto removeTbProducto(Producto tbProducto) {
		getTbProductos().remove(tbProducto);
		tbProducto.setTbProveedor(null);

		return tbProducto;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj)
	        return true;
	    if (obj == null)
	        return false;
	    if (!(obj instanceof Proveedor))
	        return false;
	    if(this.idProveedor == ((Proveedor)obj).idProveedor)
	    	return true;
	    return false;
	}

}