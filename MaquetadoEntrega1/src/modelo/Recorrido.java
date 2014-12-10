package modelo;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
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
	
	@ElementCollection
	@CollectionTable(name="DIA", joinColumns=@JoinColumn(name="ID_RECORRIDO"))
	@Column(name="DIA")
	private List<String> dias = null;
	
	private Time horaPartida = null;
	private Time horaLlegada = null;
	private String direccionDesde = null;
	private String direccionHasta = null;
	private String urlGoogleMaps = null;
	private Date fecha = null;
	
	@Column(name="TIPO_REGISTRO") 
	@Enumerated(EnumType.ORDINAL) 	
	private Registro tipoDeRegistro = null;
	
	@ManyToOne
	@JoinColumn(name = "ID_EVENTO_ACADEMICO")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private EventoAcademico evento = null;
	
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="ID_USUARIO")	
	private List<Usuario> participantesDelRecorrido = null;
	
	private boolean activo = false;
	
	private static final long serialVersionUID = -6472496352531938439L;

	public Recorrido() {
		// TODO Auto-generated constructor stub
	}

	public Recorrido(Tipo tipo, List<String> dias, Time horaPartida,
			Time horaLlegada, String direccionDesde, String direccionHasta,
			String urlGoogleMaps, Date fecha, Registro tipoDeRegistro,
			EventoAcademico evento, List<Usuario> participantesDelRecorrido, boolean activo) {
		super();
		this.tipo = tipo;
		this.dias = dias;
		this.horaPartida = horaPartida;
		this.horaLlegada = horaLlegada;
		this.direccionDesde = direccionDesde;
		this.direccionHasta = direccionHasta;
		this.urlGoogleMaps = urlGoogleMaps;
		this.fecha = fecha;
		this.tipoDeRegistro = tipoDeRegistro;
		this.evento = evento;
		this.participantesDelRecorrido = participantesDelRecorrido;
		this.activo = activo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public List<String> getDias() {
		return dias;
	}

	public void setDias(List<String> dias) {
		this.dias = dias;
	}

	public Time getHoraPartida() {
		return horaPartida;
	}

	public void setHoraPartida(Time horaPartida) {
		this.horaPartida = horaPartida;
	}

	public Time getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(Time horaLlegada) {
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public List<Usuario> getParticipantesDelRecorrido() {
		return participantesDelRecorrido;
	}

	public void setParticipantesDelRecorrido(List<Usuario> participantesDelRecorrido) {
		this.participantesDelRecorrido = participantesDelRecorrido;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	

}
