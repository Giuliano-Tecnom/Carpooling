package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Puntaje implements Serializable {

	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private long id;
	
	@ElementCollection
	@CollectionTable(name="PUNTAJE", joinColumns=@JoinColumn(name="ID_PUNTAJE"))
	@Column(name="PUNTAJE")
	private List<Integer> puntajes = null; //esta atributo representa a los puntajes recibidos en un viaje por todos los que viajaban en ese viaje y puntuaron al usuario
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario = null; //esta atributo representa el usuario a puntuar
	
	@ManyToOne
	@JoinColumn(name = "ID_RECORRIDO")
	private Recorrido viaje = null; //este atributo representa el viaje por el cual se puntuo al usuario
	
	private static final long serialVersionUID = -7830176998380700150L;

	public Puntaje() {
		// TODO Auto-generated constructor stub
	}

	public Puntaje(List<Integer> puntajes, Usuario usuario, Recorrido viaje) {
		super();
		this.puntajes = puntajes;
		this.usuario = usuario;
		this.viaje = viaje;
	}

	private long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public List<Integer> getPuntajes() {
		return puntajes;
	}

	public void setPuntajes(List<Integer> puntajes) {
		this.puntajes = puntajes;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Recorrido getViaje() {
		return viaje;
	}

	public void setViaje(Recorrido viaje) {
		this.viaje = viaje;
	}

	
}
