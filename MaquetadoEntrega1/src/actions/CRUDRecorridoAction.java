package actions;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;






import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import modelo.EventoAcademico;
import modelo.Recorrido;
import modelo.Usuario;
import modelo.Recorrido.Registro;
import modelo.Recorrido.Tipo;
import modelo.UsuarioRecorrido;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import daos.EventoAcademicoDAO;
import daos.RecorridoDAO;
import daos.UsuarioDAO;
import daos.UsuarioRecorridoDAO;

public class CRUDRecorridoAction extends ActionSupport {
	 
	private String idEventoAcademicoSeleccionado;
	
	 
	 private Recorrido recorrido;
	 
	 private Usuario usuarioLogueado;
	
	 private HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	 
	 private String id;
	 private String registoViajeComo;
	 private String tipoViaje;
	 private String fechaSalida;
	 private String fechaVuelta;
	 private String IdaVuelta;
	 private String horaPartida;
	 private String horaRegreso;
	 private String direccionInicio;
	 private String direccionFin;
	 private String asientosDisponibles;
	 
	 private ArrayList<UsuarioRecorrido> recorridosRealizados;
	 private ArrayList<Usuario> usuarios;
	 
	 private UsuarioDAO usuarioDAO;
	 private EventoAcademicoDAO eventoAcademicoDAO;
	 private UsuarioRecorridoDAO usuarioRecorridoDAO;
	 private RecorridoDAO recorridoDAO;
	 
	 private String dondeViene;
	
	public CRUDRecorridoAction() {
		this.usuarioLogueado = ((Usuario)request.getSession().getAttribute("usuarioViajero"));
	}
		
	 
	 public String create(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		if((this.getAsientosDisponibles() == null || this.getIdEventoAcademicoSeleccionado() == null || this.getRegistoViajeComo() == null || this.getTipoViaje() == null || this.getFechaSalida() == null || this.getFechaVuelta() == null ||this.getIdaVuelta() == null || this.getHoraPartida() == null || this.getHoraRegreso() == null) && request.getSession().getAttribute("usuarioViajero") == null){
			return INPUT;
		}else{
			
			EventoAcademico evento = null;
			if(this.getIdEventoAcademicoSeleccionado() != ""){
				evento = (EventoAcademico) eventoAcademicoDAO.find(Long.parseLong(this.getIdEventoAcademicoSeleccionado()));
			}
			
			Tipo tip = Tipo.valueOf(this.getTipoViaje());
			Registro reg = Registro.valueOf(this.getRegistoViajeComo());
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat formatter2 = new SimpleDateFormat("H:mm");
			
			Date fechIni = null;
			Date fecFin = null;
			Date horaPar = null;
			Date horaReg = null;
			int asientosDis = 0;
			try {
				fechIni = formatter.parse(this.getFechaSalida());
				fecFin = formatter.parse(this.getFechaVuelta());
				horaPar = formatter2.parse(this.getHoraPartida());
				horaReg = formatter2.parse(this.getHoraRegreso());
				asientosDis = Integer.parseInt(this.getAsientosDisponibles());

			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			//hacerlo como en los otros
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioViajero");
			Recorrido recor = new Recorrido(tip,horaPar,horaReg,this.getDireccionInicio(),this.getDireccionFin(),"URL Google maps",fechIni,fecFin,reg,evento,true,asientosDis);
			
			UsuarioRecorrido usuRecor = new UsuarioRecorrido(recor,usuario,null,true);
			usuarioRecorridoDAO.save(usuRecor);
			
			evento.agregarRecorrido(recor);
			eventoAcademicoDAO.update(evento);
			return SUCCESS;
		}
		
		
		
		
	}
	
	public String detailRecorrido(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST );
		if(request.getSession().getAttribute("usuarioViajero") != null && request.getParameter("id") != null && request.getParameter("v") != null){
			Long idRecorrido = Long.parseLong(request.getParameter("id"));
			Recorrido recor = (Recorrido) recorridoDAO.find(idRecorrido);
			this.setRecorrido(recor);
			if(request.getParameter("v").equalsIgnoreCase("M")){
				this.setDondeViene("listadoMisRecorridos");
			}else if(request.getParameter("v").equalsIgnoreCase("T")){
				this.setDondeViene("listadoEventosCongresos");
			}else{
				return INPUT;
			}
			
			return SUCCESS;
		}else{
			return INPUT;
		}
		
	}
	

	public String listMisRecorridos(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		if(request.getSession().getAttribute("usuarioViajero") != null){
			Long id = ((Usuario)request.getSession().getAttribute("usuarioViajero")).getId();
			this.setRecorridosRealizados(usuarioRecorridoDAO.getRecorridosDeUnUsuario(id));
			return SUCCESS;
		}else{
			return INPUT;
		}
		
	}
	
	public String listEventosCongresosTodos(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		if(request.getSession().getAttribute("usuarioViajero") != null){
			Long id = ((Usuario)request.getSession().getAttribute("usuarioViajero")).getId();
			this.setRecorridosRealizados(usuarioRecorridoDAO.getRecorridosTodos(id));
			return SUCCESS;
		}else{
			return INPUT;
		}
		
	}
	
	public String solicitarParticiparDelRecorrido(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST );
		if(request.getSession().getAttribute("usuarioViajero") != null && request.getParameter("id") != null){
			Long idRecorrido = Long.parseLong(request.getParameter("id"));
			Recorrido recor = (Recorrido) recorridoDAO.find(idRecorrido);
			recor.agregarUsuario((Usuario)request.getSession().getAttribute("usuarioViajero"));		
			recorridoDAO.update(recor);
			return SUCCESS;
		}else{
			return INPUT;
		}
		
		
	}
	
	public String darseDeBajaDelRecorrido(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST );
		if(request.getSession().getAttribute("usuarioViajero") != null && request.getParameter("id") != null){
			Long idRecorrido = Long.parseLong(request.getParameter("id"));
			Recorrido recor = (Recorrido) recorridoDAO.find(idRecorrido);
			recor.eliminarUsuario((Usuario)request.getSession().getAttribute("usuarioViajero"));	
			recorridoDAO.update(recor);
			return SUCCESS;
		}else{
			return INPUT;
		}
		
	}
	
	public String rechazarUsuarioDelRecorrido(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST );
		if(request.getSession().getAttribute("usuarioViajero") != null && request.getParameter("idUsuario") != null && request.getParameter("idRecorrido") != null){
			Long idUsuario = Long.parseLong(request.getParameter("idUsuario"));
			Long idRecorrido = Long.parseLong(request.getParameter("idRecorrido"));
			Recorrido recor = (Recorrido) recorridoDAO.find(idRecorrido);
			Usuario usu = (Usuario) usuarioDAO.find(idUsuario);
			recor.eliminarUsuario(usu);	
			recorridoDAO.update(recor);
			return SUCCESS;
		}else{
			return INPUT;
		}
		
	}
	
	public String cancelarSuscripcionRecorrido(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST );
		if(request.getSession().getAttribute("usuarioViajero") != null && request.getParameter("id") != null){
			Long idRecorrido = Long.parseLong(request.getParameter("id"));
			Recorrido recor = (Recorrido) recorridoDAO.find(idRecorrido);
			recor.eliminarUsuarioDelRecorrido((Usuario)request.getSession().getAttribute("usuarioViajero"));
			recorridoDAO.update(recor);
			return SUCCESS;
		}else{
			return INPUT;
		}
		
	}
	
	public String listadoDeSolicitudesDeParticipacionAlRecorrido(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST );
		if(request.getSession().getAttribute("usuarioViajero") != null && request.getParameter("id") != null){
			Long idRecorrido = Long.parseLong(request.getParameter("id"));
			Recorrido recor = (Recorrido) recorridoDAO.find(idRecorrido);
			this.setRecorrido(recor);
			this.usuarios = new ArrayList<Usuario>();
			this.usuarios.addAll(recor.getSolicitaronUnirseAlRecorrido());
			return SUCCESS;
		}else{
			return INPUT;
		}
		
	}
	
	public String incluirUsuarioAlRecorrido(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST );
		if(request.getSession().getAttribute("usuarioViajero") != null && request.getParameter("idUsuario") != null && request.getParameter("idRecorrido") != null){
			Long idUsuario = Long.parseLong(request.getParameter("idUsuario"));
			Long idRecorrido = Long.parseLong(request.getParameter("idRecorrido"));
			Recorrido recor = (Recorrido) recorridoDAO.find(idRecorrido);
			Usuario usu = (Usuario) usuarioDAO.find(idUsuario);
			recor.incluirUsuarioAlRecorrido(usu);
			recorridoDAO.update(recor);
			return SUCCESS;
		}else{
			return INPUT;
		}
		
		
	}
	
	public String eliminarUsuarioRecorrido(){
		
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST );
		if(request.getSession().getAttribute("usuarioViajero") != null && request.getParameter("idUsuario") != null && request.getParameter("idRecorrido") != null){
			Long idUsuario = Long.parseLong(request.getParameter("idUsuario"));
			Long idRecorrido = Long.parseLong(request.getParameter("idRecorrido"));
			Recorrido recor = (Recorrido) recorridoDAO.find(idRecorrido);
			Usuario usu = (Usuario) usuarioDAO.find(idUsuario);
			recor.eliminarUsuarioDelRecorrido(usu);
			recorridoDAO.update(recor);
			return SUCCESS;
		}else{
			return INPUT;
		}
		
	}
	
	public String edit(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST );
		if(request.getSession().getAttribute("usuarioViajero") != null && request.getParameter("id") != null){
			Long idRecorrido = Long.parseLong(request.getParameter("id"));
			Recorrido recor = (Recorrido) recorridoDAO.find(idRecorrido);
			
			this.setRecorrido(recor);
			this.setId(idRecorrido.toString());
			this.setFechaSalida(recor.returnDateWithNotTime(recor.getFechaSalida()));
			this.setFechaVuelta(recor.returnDateWithNotTime(recor.getFechaVuelta()));
			this.setHoraPartida(recor.returnTimeOfDate(recor.getHoraPartida()));
			this.setHoraRegreso(recor.returnTimeOfDate(recor.getHoraLlegada()));
			
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	public String update(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST );
		if(request.getSession().getAttribute("usuarioViajero") != null){
			
			//Al id lo spliteo porque viene 1, 1 o 2, 2 .. Totalmente inexplicable pero bueno
			String[] parts = this.getId().split(",");
			Long idRecorrido = Long.parseLong(parts[0]);
			
			Recorrido recor = (Recorrido) recorridoDAO.find(idRecorrido);
			
			recor.setAsientosDisponibles(Integer.parseInt(this.getAsientosDisponibles()));
			recor.setTipoDeRegistro(Registro.valueOf(this.getRegistoViajeComo()));
			recor.setTipo(Tipo.valueOf(this.getTipoViaje()));
			recor.setDireccionDesde(this.getDireccionInicio());
			recor.setDireccionHasta(this.getDireccionFin());
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat formatter2 = new SimpleDateFormat("hh:mm");
			Date fDesde = new Date();
			Date fHasta = new Date();
			Date hPartida = new Date();
			Date hLlegada = new Date();
			try {
				fDesde = formatter.parse(this.getFechaSalida());
				fHasta = formatter.parse(this.getFechaVuelta());
				hPartida = formatter2.parse(this.getHoraPartida());
				hLlegada = formatter2.parse(this.getHoraRegreso());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			recor.setFechaSalida(fDesde);
			recor.setFechaVuelta(fHasta);
			recor.setHoraLlegada(hLlegada);
			recor.setHoraPartida(hPartida);
			
			
			recorridoDAO.update(recor);
			
			return SUCCESS;
		}else{
			return INPUT;
		}
	}

	public String delete(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST );
		if(request.getSession().getAttribute("usuarioViajero") != null && request.getParameter("id") != null){
			Long idRecorrido = Long.parseLong(request.getParameter("id"));
			Recorrido recor = (Recorrido) recorridoDAO.find(idRecorrido);
			
			recor.setActivo(false);
			recorridoDAO.update(recor);
			
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	//----------------------------------------------- GETTERS y SETTERS-------------------------------------
	
	
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Usuario getUsuarioLogueado() {
		return usuarioLogueado;
	}


	public void setUsuarioLogueado(Usuario usuarioLogueado) {
		this.usuarioLogueado = usuarioLogueado;
	}


	public HttpServletRequest getRequest() {
		return request;
	}


	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	public String getDondeViene() {
		return dondeViene;
	}

	public void setDondeViene(String dondeViene) {
		this.dondeViene = dondeViene;
	}

	public Recorrido getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(Recorrido recorrido) {
		this.recorrido = recorrido;
	}

	public String getAsientosDisponibles() {
		return asientosDisponibles;
	}

	public void setAsientosDisponibles(String asientosDisponibles) {
		this.asientosDisponibles = asientosDisponibles;
	}
	public ArrayList<UsuarioRecorrido> getRecorridosRealizados() {
		return recorridosRealizados;
	}
	public void setRecorridosRealizados(
			ArrayList<UsuarioRecorrido> recorridosRealizados) {
		this.recorridosRealizados = recorridosRealizados;
	}
	public RecorridoDAO getRecorridoDAO() {
		return recorridoDAO;
	}

	public void setRecorridoDAO(RecorridoDAO recorridoDAO) {
		this.recorridoDAO = recorridoDAO;
	}

	public UsuarioRecorridoDAO getUsuarioRecorridoDAO() {
		return usuarioRecorridoDAO;
	}


	public void setUsuarioRecorridoDAO(UsuarioRecorridoDAO usuarioRecorridoDAO) {
		this.usuarioRecorridoDAO = usuarioRecorridoDAO;
	}


	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}


	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}


	public EventoAcademicoDAO getEventoAcademicoDAO() {
		return eventoAcademicoDAO;
	}


	public void setEventoAcademicoDAO(EventoAcademicoDAO eventoAcademicoDAO) {
		this.eventoAcademicoDAO = eventoAcademicoDAO;
	}


	
	public String getIdEventoAcademicoSeleccionado() {
		return idEventoAcademicoSeleccionado;
	}


	public void setIdEventoAcademicoSeleccionado(
			String idEventoAcademicoSeleccionado) {
		this.idEventoAcademicoSeleccionado = idEventoAcademicoSeleccionado;
	}


	public String getRegistoViajeComo() {
		return registoViajeComo;
	}


	public void setRegistoViajeComo(String registoViajeComo) {
		this.registoViajeComo = registoViajeComo;
	}


	public String getTipoViaje() {
		return tipoViaje;
	}


	public void setTipoViaje(String tipoViaje) {
		this.tipoViaje = tipoViaje;
	}

	
	
	public String getFechaSalida() {
		return fechaSalida;
	}


	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}


	public String getFechaVuelta() {
		return fechaVuelta;
	}


	public void setFechaVuelta(String fechaVuelta) {
		this.fechaVuelta = fechaVuelta;
	}


	public String getIdaVuelta() {
		return IdaVuelta;
	}


	public void setIdaVuelta(String idaVuelta) {
		IdaVuelta = idaVuelta;
	}


	public String getHoraPartida() {
		return horaPartida;
	}


	public void setHoraPartida(String horaPartida) {
		this.horaPartida = horaPartida;
	}


	public String getHoraRegreso() {
		return horaRegreso;
	}


	public void setHoraRegreso(String horaRegreso) {
		this.horaRegreso = horaRegreso;
	}


	public String getDireccionInicio() {
		return direccionInicio;
	}


	public void setDireccionInicio(String direccionInicio) {
		this.direccionInicio = direccionInicio;
	}


	public String getDireccionFin() {
		return direccionFin;
	}


	public void setDireccionFin(String direccionFin) {
		this.direccionFin = direccionFin;
	}
	
	

}
