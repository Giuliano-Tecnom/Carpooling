package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EventoAcademico implements Serializable {

	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private long id;
	
	private String nombre = null;
	private String telefono = null;
	private String direccion = null;
	private Date fechaDeCreacion = null;
	
	private static final long serialVersionUID = 2237197716747634048L;

	public EventoAcademico() {
		// TODO Auto-generated constructor stub
	}

	public EventoAcademico(String nombre, String telefono, String direccion,
			Date fechaDeCreacion) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fechaDeCreacion = fechaDeCreacion;
	}

	private long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public void setFechaDeCreacion(Date fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}
	
	

}
