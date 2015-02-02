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
	@JoinColumn(name = "ID_USUARIO_A_PUNTUAR")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Usuario usuarioAPuntuar = null; //esta atributo representa el usuario a puntuar
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO_QUE_PUNTUO")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Usuario usuarioQuePuntuo = null;
	
	private boolean activo = false;
	
	private static final long serialVersionUID = -7830176998380700150L;

	public Puntaje() {
		// TODO Auto-generated constructor stub
	}

	public Puntaje(long id, TipoPuntaje tipoPuntaje, Usuario usuarioAPuntuar,
			Usuario usuarioQuePuntuo, boolean activo) {
		super();
		this.id = id;
		this.tipoPuntaje = tipoPuntaje;
		this.usuarioAPuntuar = usuarioAPuntuar;
		this.usuarioQuePuntuo = usuarioQuePuntuo;
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

	public Usuario getUsuarioAPuntuar() {
		return usuarioAPuntuar;
	}

	public void setUsuarioAPuntuar(Usuario usuarioAPuntuar) {
		this.usuarioAPuntuar = usuarioAPuntuar;
	}

	public Usuario getUsuarioQuePuntuo() {
		return usuarioQuePuntuo;
	}

	public void setUsuarioQuePuntuo(Usuario usuarioQuePuntuo) {
		this.usuarioQuePuntuo = usuarioQuePuntuo;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	
}
