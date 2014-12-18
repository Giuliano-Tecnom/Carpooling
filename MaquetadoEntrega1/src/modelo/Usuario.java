package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class Usuario extends Persona implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7876561796406529412L;
	
	public enum Tipo {
		ADMINISTRADOR, VIAJERO
	}
	
	@Column(name="TIPO_USUARIO") 
	@Enumerated(EnumType.ORDINAL) 	
	private Tipo tipo = null;
	
	private String usuario = null;
	private String pass = null;
	private boolean activo = false;
	
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="ID_USUARIO")	
	private List<Recorrido> recorridosRealizados = null;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_USUARIO")	
	private List<Puntaje> puntajesRecibidos = null;
	
	@OneToMany(cascade=CascadeType.ALL)	
	@JoinColumn(name="ID_USUARIO")	
	private List<Denuncia> denunciasRealizadas = null;
	
	@OneToMany(cascade=CascadeType.ALL)	
	@JoinColumn(name="ID_USUARIO")	
	private List<Denuncia> denunciasRecibidas = null;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_USUARIO")	
	private List<Mensaje> mensajesRecibidos = null;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_USUARIO")	
	private List<Mensaje> mensajesEnviados = null;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	
	public Usuario(String nombre, String apellido, String telefono,
			String direccion, String email, String dni, Tipo tipo, String usuario, String pass, boolean activo,
			List<Recorrido> recorridosRealizados,
			List<Puntaje> puntajesRecibidos,
			List<Denuncia> denunciasRealizadas,
			List<Denuncia> denunciasRecibidas, 
			List<Mensaje> mensajesRecibidos,
			List<Mensaje> mensajesEnviados) {
		super(nombre, apellido, telefono, direccion, email, dni);
		// TODO Auto-generated constructor stub
		this.tipo = tipo;
		this.usuario = usuario;
		this.pass = pass;
		this.activo = activo;
		this.recorridosRealizados = recorridosRealizados;
		this.puntajesRecibidos = puntajesRecibidos;
		this.denunciasRealizadas = denunciasRealizadas;
		this.denunciasRecibidas = denunciasRecibidas;
		this.mensajesRecibidos = mensajesRecibidos;
		this.mensajesEnviados = mensajesEnviados;
	}
	
	public Usuario(String nombre, String apellido, String telefono,
			String direccion, String email, String foto, String dni, Tipo tipo, String usuario, String pass, boolean activo,
			List<Recorrido> recorridosRealizados,
			List<Puntaje> puntajesRecibidos,
			List<Denuncia> denunciasRealizadas,
			List<Denuncia> denunciasRecibidas, 
			List<Mensaje> mensajesRecibidos,
			List<Mensaje> mensajesEnviados) {
		super(nombre, apellido, telefono, direccion, email, foto, dni);
		// TODO Auto-generated constructor stub
		this.tipo = tipo;
		this.usuario = usuario;
		this.pass = pass;
		this.activo = activo;
		this.recorridosRealizados = recorridosRealizados;
		this.puntajesRecibidos = puntajesRecibidos;
		this.denunciasRealizadas = denunciasRealizadas;
		this.denunciasRecibidas = denunciasRecibidas;
		this.mensajesRecibidos = mensajesRecibidos;
		this.mensajesEnviados = mensajesEnviados;
	}

	

	public List<Denuncia> getDenunciasRecibidas() {
		return denunciasRecibidas;
	}

	public void setDenunciasRecibidas(List<Denuncia> denunciasRecibidas) {
		this.denunciasRecibidas = denunciasRecibidas;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public List<Recorrido> getRecorridosRealizados() {
		return recorridosRealizados;
	}

	public void setRecorridosRealizados(List<Recorrido> recorridosRealizados) {
		this.recorridosRealizados = recorridosRealizados;
	}

	public List<Puntaje> getPuntajesRecibidos() {
		return puntajesRecibidos;
	}

	public void setPuntajesRecibidos(List<Puntaje> puntajesRecibidos) {
		this.puntajesRecibidos = puntajesRecibidos;
	}

	public List<Denuncia> getDenunciasRealizadas() {
		return denunciasRealizadas;
	}

	public void setDenunciasRealizadas(List<Denuncia> denunciasRealizadas) {
		this.denunciasRealizadas = denunciasRealizadas;
	}

	public List<Mensaje> getMensajesRecibidos() {
		return mensajesRecibidos;
	}

	public void setMensajesRecibidos(List<Mensaje> mensajesRecibidos) {
		this.mensajesRecibidos = mensajesRecibidos;
	}

	public List<Mensaje> getMensajesEnviados() {
		return mensajesEnviados;
	}

	public void setMensajesEnviados(List<Mensaje> mensajesEnviados) {
		this.mensajesEnviados = mensajesEnviados;
	}

	
	

	

	
	

}
