package actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


import org.springframework.beans.factory.annotation.Autowired;

import modelo.Usuario;
import modelo.Usuario.Tipo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import daos.UsuarioDAO;


public class LoginAction extends ActionSupport {
	private String usuario;
	private String pass;
	
	
	private UsuarioDAO usuarioDAO; 
	
	public LoginAction(){
		
	}
	
	public String execute() {
		System.out.println("entrooooo");
		System.out.println(this.getUsuario());
		System.out.println(this.getPass());
		
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST );
		HttpSession sesion = request.getSession(true);
		System.out.println(request.getAttribute("usuarioAdministrador"));
		
		if(sesion.getAttribute("usuarioAdministrador") != null || sesion.getAttribute("usuarioViajero") != null){
			sesion.invalidate();
		};
		
		
		if (this.getUsuario()==null || this.getPass()==null)
			return INPUT;
		else {			
			System.out.println("entro al else");
			System.out.println(this.getUsuarioDAO());
			Usuario u = usuarioDAO.recuperarUsuario(this.getUsuario());
			System.out.println("todavia no exploto");
			if (u != null) {
				
				if(!u.getPass().toString().equalsIgnoreCase(this.getPass().toString())){
					System.out.println("Pass incorrecto");
					return INPUT;
				}else{
					
					sesion = request.getSession(true);
					
					if(u.getTipo() == Tipo.ADMINISTRADOR){
						sesion.setAttribute("usuarioAdministrador", u);
						return SUCCESS;
					}else{
						sesion.setAttribute("usuarioViajero", u);
						return "viajero";
					}
				}	
			}else{
				System.out.println("El usuario ingresado no está dado de alta en el sistema");
				return INPUT;
			}
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	
}
