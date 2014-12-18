package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import modelo.Denuncia;
import modelo.Mensaje;
import modelo.Puntaje;
import modelo.Recorrido;
import modelo.Usuario.Tipo;
import modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import daos.UsuarioDAO;
import daosImp.UsuarioDAOHibernateJPA;

public class RegistrarViajeroAction extends ActionSupport{
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private String pass;
	private String foto;
	private String direccion;
	private String dni;
	private String usuario;
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	public String execute() {
		System.out.println("entro");
		System.out.println(this.getNombre() +" - "+ this.getApellido() +" - "+ this.getEmail() +" - "+ this.getTelefono() +" - "+ this.getPass() + " - " + this.getFoto() +" - " + this.getDireccion() + " - " + this.getDni() + " - " + this.getUsuario() );
		
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST );
		HttpSession sesion = request.getSession(true);
		
		if(sesion.getAttribute("usuarioAdministrador") != null || sesion.getAttribute("usuarioViajero") != null){
			sesion.invalidate();
		};
		
		if(this.getNombre() == null || this.getApellido() == null || this.getEmail() == null || this.getTelefono() == null || this.getPass() == null || this.getDireccion() == null || this.getDni() == null || this.getUsuario() == null){
			System.out.println("campo vacio");
			return INPUT;	
		}else{
			System.out.println("Creando usuario");
			
			//UsuarioDAOHibernateJPA g = new UsuarioDAOHibernateJPA();
			Usuario u = new Usuario(
					this.getNombre(),
					this.getApellido(),
					this.getTelefono(),
					this.getDireccion(),
					this.getEmail(),					
					this.getDni(),
					Tipo.VIAJERO,
					this.getUsuario(),
					this.getPass(),
					true,
					new ArrayList<Recorrido>(),
					new ArrayList<Puntaje>(), 
					new ArrayList<Denuncia>(), 
					new ArrayList<Denuncia>(),
					new ArrayList<Mensaje>(),
					new ArrayList<Mensaje>());
			usuarioDAO.save(u);
			System.out.println("Guardo correctamente");
			
			sesion = request.getSession(true);
			sesion.setAttribute("usuarioViajero", u);
			System.out.println(sesion.getAttribute("usuarioViajero"));
			return SUCCESS;
		}
		
		
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
