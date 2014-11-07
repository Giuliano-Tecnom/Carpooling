package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Denuncia implements Serializable {

	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private long id;
	private String descripcion = null;
	private Date fecha = null;
	private boolean activo = false;
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario dirigida;
	
	private static final long serialVersionUID = 3389132037727561760L;

	public Denuncia() {
		// TODO Auto-generated constructor stub
	}

	public Denuncia(String descripcion, Date fecha, boolean activo, Usuario dirigida) {
		super();
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.activo = activo;
		this.dirigida = dirigida;
	}

	private long getId() {
		return id;
	}	
	
	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Usuario getDirigida() {
		return dirigida;
	}

	public void setDirigida(Usuario dirigida) {
		this.dirigida = dirigida;
	}

	private void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	

}
