package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;


@Entity
public class EventoAcademico implements Serializable {

	public enum Tipo {
		CONGRESO, ACADEMICO
	}
	
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
	private Date fechaInicio = null;
	private Date fechaFin = null;
	private String horaDesdeHasta = null;
	
	private boolean activo = false;
	
	@Column(name="TIPO_EVENTO") 
	@Enumerated(EnumType.ORDINAL) 	
	private Tipo tipo = null;
	
	@OneToMany()
	@JoinColumn(name="ID_EVENTO")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Recorrido> recorridos = null;
	
	private static final long serialVersionUID = 2237197716747634048L;

	public EventoAcademico() {
		// TODO Auto-generated constructor stub
	}

	

	public EventoAcademico(String nombre, String telefono, String direccion,
			Date fechaDeCreacion, Date fechaInicio, Date fechaFin,
			String horaDesdeHasta, boolean activo, Tipo tipo) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fechaDeCreacion = fechaDeCreacion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.horaDesdeHasta = horaDesdeHasta;
		this.activo = activo;
		this.tipo = tipo;
	}


	public List<Recorrido> getRecorridos() {
		return recorridos;
	}
	
	public void setRecorridos(List<Recorrido> recorridos) {
		this.recorridos = recorridos;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getHoraDesdeHasta() {
		return horaDesdeHasta;
	}

	public void setHoraDesdeHasta(String horaDesdeHasta) {
		this.horaDesdeHasta = horaDesdeHasta;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
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

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public String returnDateWithNotTime(Date fecha){
		String[] parts = fecha.toString().split(" ");
		return parts[0]; 
	}
	
	public void marcarRecorridosComoInactivos(){
		//debería recorrer la coleccion de recorridos y marcarlos todos como inactivos
		try{			
			if(!this.getRecorridos().isEmpty()){
				Iterator<Recorrido> iterator = this.getRecorridos().iterator();
				while(iterator.hasNext()){
					iterator.next().setActivo(false);
				}	
            }
		}catch(Exception name){
			System.err.println("Error: " +name);
		}	
	}
	
	public void agregarRecorrido(Recorrido recorrido){
		this.getRecorridos().add(recorrido);
	}

}
