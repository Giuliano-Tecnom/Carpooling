package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;

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
	@JoinColumn(name = "ID_USUARIO_DIRIGIDA")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Usuario dirigida;
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO_HIZO")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Usuario hizo;
	
	private static final long serialVersionUID = 3389132037727561760L;

	public Denuncia() {
		// TODO Auto-generated constructor stub
	}

	

	public Usuario getHizo() {
		return hizo;
	}
	
	public void setHizo(Usuario hizo) {
		this.hizo = hizo;
	}
	
	public long getId() {
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
