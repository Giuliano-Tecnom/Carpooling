package modelo;

import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Column;
import javax.persistence.Entity;

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
	

	public Usuario(String nombre, String apellido, String telefono,
			String direccion, String email, String foto, String dni,Tipo tipo, String usuario, String pass, boolean activo) {
		super(nombre, apellido, telefono, direccion, email, foto, dni);
		this.tipo = tipo;
		this.usuario = usuario;
		this.pass = pass;
		this.activo = activo;
	}

	
	public Usuario() {
		// TODO Auto-generated constructor stub
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
}
