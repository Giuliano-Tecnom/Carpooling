package actions;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import modelo.EventoAcademico;
import modelo.EventoAcademico.Tipo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import daos.EventoAcademicoDAO;
import daosImp.EventoAcademicoDAOHibernateJPA;

public class CRUDEventoAcademicoAction extends ActionSupport{
	@Autowired
	private EventoAcademicoDAO eventoAcademicoDAO;
	
	private String nombre;
	private String telefono;
	private String direccion;
	private Date fechaDeCreacion;
	private String fechaInicio;
	private String fechaFin;
	private String horaDesdeHasta;
	
	private String tipo;
	private boolean activo;
	
	private EventoAcademico evento;
	private ArrayList<EventoAcademico> eventos;
	
	public String create() throws ParseException{
		System.out.println("entroooo");
		System.out.println(this.getNombre() + " - " +this.getTelefono()+ " - " +this.getDireccion()+ " - " + this.getTipo() +" - " + this.getFechaInicio() + " - "+ this.getFechaFin() + " - " + this.getHoraDesdeHasta() );
		
		if(this.getNombre() == null || this.getTelefono() == null || this.getDireccion() == null || this.getTipo() == null || this.getFechaFin() == null || this.getFechaInicio() == null || this.getHoraDesdeHasta() == null){
			System.out.println("Campo vacio");
			return INPUT;
		}else{
			//EventoAcademicoDAOHibernateJPA g = new EventoAcademicoDAOHibernateJPA();
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date fechIni = formatter.parse(this.getFechaInicio());
			Date fecFin = formatter.parse(this.getFechaFin());
			this.setActivo(true);
			Tipo tip = Tipo.valueOf(this.getTipo());
			
			EventoAcademico e = new EventoAcademico(this.getNombre(),this.getTelefono(),this.getDireccion(),new Date(),fechIni,fecFin,this.getHoraDesdeHasta(),this.getActivo(),tip);
			eventoAcademicoDAO.save(e);
			return SUCCESS;
		}
		
	}
	
	
	public String list(){
		System.out.println("Entroooooooo");
		//EventoAcademicoDAOHibernateJPA g = new EventoAcademicoDAOHibernateJPA();
		this.setEventos((ArrayList<EventoAcademico>)eventoAcademicoDAO.list());
		return SUCCESS;
	}
	
	public String detail(){
		System.out.println("Entro al detalle");
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST );
		Long id = Long.parseLong(request.getParameter("id"));
		
		//EventoAcademicoDAOHibernateJPA g = new EventoAcademicoDAOHibernateJPA();
		EventoAcademico e = (EventoAcademico) eventoAcademicoDAO.find(id);
		this.setEvento(e);
		
		System.out.println("id del evento: "+ id);
		return SUCCESS;
		
	}
	public EventoAcademicoDAO getEventoAcademicoDAO() {
		return eventoAcademicoDAO;
	}
	public void setEventoAcademicoDAO(EventoAcademicoDAO eventoAcademicoDAO) {
		this.eventoAcademicoDAO = eventoAcademicoDAO;
	}
	public EventoAcademico getEvento() {
		return evento;
	}

	public void setEvento(EventoAcademico evento) {
		this.evento = evento;
	}

	public ArrayList<EventoAcademico> getEventos() {
		return eventos;
	}

	public void setEventos(ArrayList<EventoAcademico> eventos) {
		this.eventos = eventos;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getHoraDesdeHasta() {
		return horaDesdeHasta;
	}

	public void setHoraDesdeHasta(String horaDesdeHasta) {
		this.horaDesdeHasta = horaDesdeHasta;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean getActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
}
