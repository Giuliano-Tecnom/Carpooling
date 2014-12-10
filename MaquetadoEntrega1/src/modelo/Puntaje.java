package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

import modelo.Usuario.Tipo;

@Entity
public class Puntaje implements Serializable {


	public enum TipoPuntaje {
		MUYBUENO, BUENO, MALO, MUYMALO, EXCELENTE
	}
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private long id;	
	
	@Column(name="TIPO_PUNTAJE") 
	@Enumerated(EnumType.ORDINAL) 	
	private TipoPuntaje tipoPuntaje = null;
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Usuario usuario = null; //esta atributo representa el usuario a puntuar
	
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="ID_USUARIO")	
	private List<UsuarioRecorrido> usuariosQuePuntuaron = null;
	
	private boolean activo = false;
	
	private static final long serialVersionUID = -7830176998380700150L;

	public Puntaje() {
		// TODO Auto-generated constructor stub
	}

	public Puntaje(TipoPuntaje tipoPuntaje, Usuario usuario, List<UsuarioRecorrido> viaje,boolean activo) {
		super();
		this.tipoPuntaje = tipoPuntaje;
		this.usuario = usuario;
		this.usuariosQuePuntuaron = viaje;
		this.activo = activo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

	public TipoPuntaje getTipoPuntaje() {
		return tipoPuntaje;
	}

	public void setTipoPuntaje(TipoPuntaje tipoPuntaje) {
		this.tipoPuntaje = tipoPuntaje;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<UsuarioRecorrido> getUsuariosQuePuntuaron() {
		return usuariosQuePuntuaron;
	}

	public void setUsuariosQuePuntuaron(List<UsuarioRecorrido> usuariosQuePuntuaron) {
		this.usuariosQuePuntuaron = usuariosQuePuntuaron;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	

	
}
