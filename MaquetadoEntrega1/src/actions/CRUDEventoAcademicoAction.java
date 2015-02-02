package actions;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import modelo.EventoAcademico;
import modelo.Usuario;
import modelo.EventoAcademico.Tipo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import daos.EventoAcademicoDAO;
import daosImp.EventoAcademicoDAOHibernateJPA;

public class CRUDEventoAcademicoAction extends ActionSupport{
	@Autowired
	private EventoAcademicoDAO eventoAcademicoDAO;
	
	private String id;
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
	
	
	
	public CRUDEventoAcademicoAction(){
		
	}
	
	public String create() throws ParseException{
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		if((this.getNombre() == null || this.getTelefono() == null || this.getDireccion() == null || this.getTipo() == null || this.getFechaFin() == null || this.getFechaInicio() == null || this.getHoraDesdeHasta() == null) && request.getSession().getAttribute("usuarioAdministrador") == null){
			return INPUT;
		}else{
			System.out.println(this.getDireccion());
			
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
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		if(request.getSession().getAttribute("usuarioAdministrador") != null || request.getSession().getAttribute("usuarioViajero") != null){
			this.setEventos((ArrayList<EventoAcademico>)eventoAcademicoDAO.listActive());
			return SUCCESS;
		}else{
			return INPUT;
		}
		
	}
	
	public String detail(){
		
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST );
		if((request.getSession().getAttribute("usuarioAdministrador") != null || request.getSession().getAttribute("usuarioViajero") != null) && request.getParameter("id") != null){
			
			Long id = Long.parseLong(request.getParameter("id"));
			
			EventoAcademico e = (EventoAcademico) eventoAcademicoDAO.find(id);
			this.setEvento(e);
			
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	public String edit(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST );
		if((request.getSession().getAttribute("usuarioAdministrador") != null || request.getSession().getAttribute("usuarioViajero") != null) && request.getParameter("id") != null){
			
			Long id = Long.parseLong(request.getParameter("id"));
			
			EventoAcademico e = (EventoAcademico) eventoAcademicoDAO.find(id);
			
			this.setId(id.toString());
			
			e.setFechaDeCreacion(new Date());
			this.setEvento(e);
			
			this.setFechaInicio(e.returnDateWithNotTime(e.getFechaInicio()));
			this.setFechaFin(e.returnDateWithNotTime(e.getFechaFin()));
			
						
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	public String update(){
		System.out.println(this.getId());

		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST );
		if(request.getSession().getAttribute("usuarioAdministrador") != null || request.getSession().getAttribute("usuarioViajero") != null){
			
			Long id = Long.parseLong(this.getId());
			
			EventoAcademico e = (EventoAcademico) eventoAcademicoDAO.find(id);
			
			e.setDireccion(this.getDireccion());
			e.setFechaDeCreacion(new Date());
			e.setTelefono(this.getTelefono());
			e.setHoraDesdeHasta(this.getHoraDesdeHasta());
			e.setNombre(this.getNombre());
			e.setTipo(Tipo.valueOf(this.getTipo()));
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date fechIni = new Date();
			Date fecFin = new Date();
			try {
				fechIni = formatter.parse(this.getFechaInicio());
				fecFin = formatter.parse(this.getFechaFin());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.setFechaInicio(fechIni);
			e.setFechaFin(fecFin);
			
			eventoAcademicoDAO.update(e);
			
			return SUCCESS;
		}else{
			return INPUT;
		}
		
		
		
	}
	
	public String delete(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST );
		if((request.getSession().getAttribute("usuarioAdministrador") != null || request.getSession().getAttribute("usuarioViajero") != null) && request.getParameter("id") != null){
			
			Long id = Long.parseLong(request.getParameter("id"));
			EventoAcademico e = (EventoAcademico) eventoAcademicoDAO.find(id);
			e.setActivo(false);
			e.marcarRecorridosComoInactivos();
			eventoAcademicoDAO.update(e);
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	//-------------------------------------GETTERS ANS SETTERS------------------------------
	
	
	
	
	public EventoAcademicoDAO getEventoAcademicoDAO() {
		return eventoAcademicoDAO;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
