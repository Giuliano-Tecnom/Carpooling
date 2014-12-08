package actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import modelo.Usuario;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import daosImp.UsuarioDAOHibernateJPA;

public class LoginAction extends ActionSupport {
	private String usuario;
	private String pass;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() {
		System.out.println("entrooooo");
		System.out.println(this.getUsuario());
		System.out.println(this.getPass());
		
		
		
		if (this.getUsuario()==null || this.getPass()==null)
			return INPUT;
		else {			
			UsuarioDAOHibernateJPA g = new UsuarioDAOHibernateJPA();
			Usuario u = (Usuario) g.recuperarUsuario(this.getUsuario());
			
			if (u != null) {
					HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST );
					HttpSession sesion = request.getSession(true);
					sesion.setAttribute("usuario", u);
					
					return SUCCESS;
			}else{
				System.out.println(u);
				return INPUT;
			}			
			
			
		}
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
