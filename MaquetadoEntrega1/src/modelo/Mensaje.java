package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Mensaje implements Serializable {

	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private long id;
	
	private String cuerpo = null;
	private Date fecha = null;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO", insertable=false, updatable=false)
	private Usuario from = null;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO", insertable=false, updatable=false)
	private Usuario to = null;
	
	private boolean activo = false;
	
	private static final long serialVersionUID = -466339413645963704L;

	public Mensaje() {
		// TODO Auto-generated constructor stub
	}

	public Mensaje(String cuerpo, Date fecha, Usuario from, Usuario to, boolean activo) {
		super();
		this.cuerpo = cuerpo;
		this.fecha = fecha;
		this.from = from;
		this.to = to;
		this.activo = activo;
	}

	private long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuario getFrom() {
		return from;
	}

	public void setFrom(Usuario from) {
		this.from = from;
	}

	public Usuario getTo() {
		return to;
	}

	public void setTo(Usuario to) {
		this.to = to;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
	
}
