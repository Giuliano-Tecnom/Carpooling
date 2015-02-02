package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import modelo.Recorrido;
import modelo.Usuario;
import modelo.Usuario.Tipo;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import daos.RecorridoDAO;
import daos.UsuarioDAO;

public class CRUDUsuarioAction extends ActionSupport{

	public CRUDUsuarioAction() {
		// TODO Auto-generated constructor stub
	}
	
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private String pass;
	private String foto;
	private String direccion;
	private String dni;
	private String usuario;
	
	private Usuario usuarioEntity;
	private Recorrido recorridoEntity;
	
	private UsuarioDAO usuarioDAO;
	private RecorridoDAO recorridoDAO;
	
	public String registrarViajero() {
		
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST );
		HttpSession sesion = request.getSession(true);
		
		if(sesion.getAttribute("usuarioAdministrador") != null || sesion.getAttribute("usuarioViajero") != null){
			sesion.invalidate();
		};
		
		if(this.getNombre() == null || this.getApellido() == null || this.getEmail() == null || this.getTelefono() == null || this.getPass() == null || this.getDireccion() == null || this.getDni() == null || this.getUsuario() == null){
			
			return INPUT;	
		}else{
			
			
			//UsuarioDAOHibernateJPA g = new UsuarioDAOHibernateJPA();
			Usuario u = new Usuario(this.getNombre(),
					this.getApellido(),
					this.getTelefono(),
					this.getDireccion(),
					"foto",
					this.getEmail(),					
					this.getDni(),
					Tipo.VIAJERO,
					this.getUsuario(),
					this.getPass(),
					true);
			usuarioDAO.save(u);
			
			
			sesion = request.getSession(true);
			sesion.setAttribute("usuarioViajero", u);
			
			return SUCCESS;
		}
		
		
	}
	
	public String cerrarSesion(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST );
		HttpSession sesion = request.getSession(true);
		if(sesion.getAttribute("usuarioViajero") != null || sesion.getAttribute("usuarioAdministrador") != null){
			sesion.invalidate();
		}
		return SUCCESS;
	}
	
	public String logIn() {
		
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST );
		HttpSession sesion = request.getSession(true);
		
		if(sesion.getAttribute("usuarioViajero") != null){
			return "viajero";
		}else if(sesion.getAttribute("usuarioAdministrador") != null){
			return SUCCESS;
		}
		
		if (this.getUsuario()==null || this.getPass()==null)
			return INPUT;
		else {			
			//vino por el registrarse
			Usuario u = usuarioDAO.recuperarUsuario(this.getUsuario());
			
			if (u != null) {
				
				if(!u.getPass().toString().equalsIgnoreCase(this.getPass().toString())){
					
					return INPUT;
				}else{
					
					if(u.getTipo() == Tipo.ADMINISTRADOR){
						sesion.setAttribute("usuarioAdministrador", u);
						return SUCCESS;
					}else{
						sesion.setAttribute("usuarioViajero", u);
						return "viajero";
					}
				}	
			}else{
				
				return INPUT;
			}
		}
	}
	
	public String detailUsuario(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST );
		if(request.getSession().getAttribute("usuarioViajero") != null || request.getSession().getAttribute("usuarioAdministrador") != null){
			Long idUsuario = Long.parseLong(request.getParameter("idUsuario"));
			Long idRecorrido = Long.parseLong(request.getParameter("idRecorrido"));
			this.setRecorridoEntity((Recorrido) recorridoDAO.find(idRecorrido));
			this.setUsuarioEntity((Usuario) usuarioDAO.find(idUsuario));
			return SUCCESS;
		}else{
			return INPUT;
		}
		
	}
	
	
	//--------------------------------------- GETTER AND SETTERS ------------------------------------------------
	
	
	
	public Usuario getUsuarioEntity() {
		return usuarioEntity;
	}

	public Recorrido getRecorridoEntity() {
		return recorridoEntity;
	}

	public void setRecorridoEntity(Recorrido recorridoEntity) {
		this.recorridoEntity = recorridoEntity;
	}

	public RecorridoDAO getRecorridoDAO() {
		return recorridoDAO;
	}

	public void setRecorridoDAO(RecorridoDAO recorridoDAO) {
		this.recorridoDAO = recorridoDAO;
	}

	public void setUsuarioEntity(Usuario usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}



	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	


}
