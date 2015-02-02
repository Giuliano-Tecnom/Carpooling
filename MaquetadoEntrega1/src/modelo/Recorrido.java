package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;









import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;





@Entity
public class Recorrido implements Serializable {
	
	/**
	 * 
	 */
	
	public enum Registro {
		CONDUCTOR,PASAJERO,AMBOS
	}
	
	public enum Tipo {
		PUNTUAL, DIARIO, PERIODICO
	}
	
	@Id
	@GeneratedValue
	private long id;
	@Column(name="TIPO_RECORRIDO") 
	@Enumerated(EnumType.ORDINAL) 	
	private Tipo tipo = null;
	
	@Column(name="TIPO_REGISTRO") 
	@Enumerated(EnumType.ORDINAL) 	
	private Registro tipoDeRegistro = null;
	
	
	
	private Date horaPartida = null;
	private Date horaLlegada = null;
	private String direccionDesde = null;
	private String direccionHasta = null;
	private String urlGoogleMaps = null;
	private Date fechaSalida = null;
	private Date fechaVuelta = null;
	private int asientosDisponibles;
	
//	@OneToMany(cascade={CascadeType.ALL})
//	@JoinColumn(name="ID_RECORRIDO_SOLICITO_UNIRSE_AL_RECORRIDO")
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "SOLICITUDES_USUARIOS_RECORRIDO",joinColumns = { 
			@JoinColumn(name = "RECORRIDO_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "USUARIO_ID", 
					nullable = false, updatable = false) })
	private List<Usuario> solicitaronUnirseAlRecorrido = new ArrayList<Usuario>();
	
//	@OneToMany(cascade={CascadeType.ALL})
//	@JoinColumn(name="ID_RECORRIDO_INTEGRANTE_DEL_RECORRIDO")
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "USUARIOS_INTEGRANTES_RECORRIDO",joinColumns = { 
			@JoinColumn(name = "RECORRIDO_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "USUARIO_ID", 
					nullable = false, updatable = false) })
	private List<Usuario> integrantesDelRecorrido = new ArrayList<Usuario>();
	
	
	
	@ManyToOne
	@JoinColumn(name = "ID_EVENTO_ACADEMICO")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private EventoAcademico evento = null;
	
	
	private boolean activo = false;
	
	private static final long serialVersionUID = -6472496352531938439L;

	public Recorrido() {
		// TODO Auto-generated constructor stub
	}
	
	public Recorrido(Tipo tipo, Date horaPartida, Date horaLlegada,
			String direccionDesde, String direccionHasta, String urlGoogleMaps,
			Date fechaSalida, Date fechaVuelta, Registro tipoDeRegistro,
			EventoAcademico evento,boolean activo,int asientos) {
		super();
		this.tipo = tipo;
		this.horaPartida = horaPartida;
		this.horaLlegada = horaLlegada;
		this.direccionDesde = direccionDesde;
		this.direccionHasta = direccionHasta;
		this.urlGoogleMaps = urlGoogleMaps;
		this.fechaSalida = fechaSalida;
		this.fechaVuelta = fechaVuelta;
		this.tipoDeRegistro = tipoDeRegistro;
		this.evento = evento;
		this.activo = activo;
		this.asientosDisponibles = asientos;
	}




	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	
	public List<Usuario> getSolicitaronUnirseAlRecorrido() {
		return solicitaronUnirseAlRecorrido;
	}

	public void setSolicitaronUnirseAlRecorrido(
			List<Usuario> solicitaronUnirseAlRecorrido) {
		this.solicitaronUnirseAlRecorrido = solicitaronUnirseAlRecorrido;
	}

	public List<Usuario> getIntegrantesDelRecorrido() {
		return integrantesDelRecorrido;
	}

	public void setIntegrantesDelRecorrido(
			List<Usuario> integrantesDelRecorrido) {
		this.integrantesDelRecorrido = integrantesDelRecorrido;
	}

	public int getAsientosDisponibles() {
		return asientosDisponibles;
	}

	public void setAsientosDisponibles(int asientosDisponibles) {
		this.asientosDisponibles = asientosDisponibles;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}


	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}


	public Date getFechaVuelta() {
		return fechaVuelta;
	}


	public void setFechaVuelta(Date fechaVuelta) {
		this.fechaVuelta = fechaVuelta;
	}


	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public Date getHoraPartida() {
		return horaPartida;
	}

	public void setHoraPartida(Date horaPartida) {
		this.horaPartida = horaPartida;
	}

	public Date getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(Date horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public String getDireccionDesde() {
		return direccionDesde;
	}

	public void setDireccionDesde(String direccionDesde) {
		this.direccionDesde = direccionDesde;
	}

	public String getDireccionHasta() {
		return direccionHasta;
	}

	public void setDireccionHasta(String direccionHasta) {
		this.direccionHasta = direccionHasta;
	}

	public String getUrlGoogleMaps() {
		return urlGoogleMaps;
	}

	public void setUrlGoogleMaps(String urlGoogleMaps) {
		this.urlGoogleMaps = urlGoogleMaps;
	}

	

	public Registro getTipoDeRegistro() {
		return tipoDeRegistro;
	}

	public void setTipoDeRegistro(Registro tipoDeRegistro) {
		this.tipoDeRegistro = tipoDeRegistro;
	}

	public EventoAcademico getEvento() {
		return evento;
	}

	public void setEvento(EventoAcademico evento) {
		this.evento = evento;
	}

	
	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public void agregarUsuario(Usuario usu){
		this.getSolicitaronUnirseAlRecorrido().add(usu);
		//boolean tiene = this.getIntegrantesDelRecorrido().contains(usu);
	}
	
	public void eliminarUsuario(Usuario usu){
		this.getSolicitaronUnirseAlRecorrido().remove(usu);
	}
	
	public void incluirUsuarioAlRecorrido(Usuario usu){
		this.getIntegrantesDelRecorrido().add(usu);
		this.asientosDisponibles--;
		this.eliminarUsuario(usu);
	}
	
	public void eliminarUsuarioDelRecorrido(Usuario usu){
		this.getIntegrantesDelRecorrido().remove(usu);
		this.asientosDisponibles++;
	}
	
	public String returnDateWithNotTime(Date fecha){
		String[] parts = fecha.toString().split(" ");
		return parts[0]; 
	}
	
	public String returnTimeOfDate(Date fecha){
		String[] parts = fecha.toString().split(" ");
		return parts[1]; 
	}
}
