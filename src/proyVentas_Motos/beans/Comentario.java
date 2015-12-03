package proyVentas_Motos.beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_comentario database table.
 * 
 */
@Entity
@Table(name="tb_comentario")
@NamedQuery(name="Comentario.findAll", query="SELECT c FROM Comentario c")
public class Comentario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idComentario;

	private String descripcion;

	private int puntuacion;

	private String titulo;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="IdCliente")
	private Cliente tbCliente;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="IdProducto")
	private Producto tbProducto;

	public Comentario() {
	}

	public int getIdComentario() {
		return this.idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPuntuacion() {
		return this.puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Cliente getTbCliente() {
		return this.tbCliente;
	}

	public void setTbCliente(Cliente tbCliente) {
		this.tbCliente = tbCliente;
	}

	public Producto getTbProducto() {
		return this.tbProducto;
	}

	public void setTbProducto(Producto tbProducto) {
		this.tbProducto = tbProducto;
	}

}