package modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
@Entity
public class UsuarioRecorrido implements Serializable {

	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_RECORRIDO")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Recorrido recorrido = null;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Usuario usuario = null;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_PUNTAJE")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Puntaje puntaje = null;
	
	private boolean activo = false;
	
	private static final long serialVersionUID = -5519484046464892609L;

	public UsuarioRecorrido() {
		// TODO Auto-generated constructor stub
	}

	public UsuarioRecorrido(Recorrido recorrido, Usuario usuario,
			Puntaje puntaje, boolean activo) {
		super();
		this.recorrido = recorrido;
		this.usuario = usuario;
		this.puntaje = puntaje;
		this.activo = activo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Recorrido getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(Recorrido recorrido) {
		this.recorrido = recorrido;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Puntaje getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Puntaje puntaje) {
		this.puntaje = puntaje;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	
	
}
