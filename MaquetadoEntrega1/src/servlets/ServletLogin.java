package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clases.Usuario;
import clasesDAO.UsuarioDAO;
import clasesqueImplementan.FactoryDAO;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		UsuarioDAO uDAO = FactoryDAO.getUsuarioDAO();
		Usuario u = uDAO.encontrar(request.getParameter("usuario"));
		String result = "/login.jsp";
		
		if (u != null) {
			
			if(u.getClave().equals(request.getParameter("clave"))){
				
				HttpSession sesion = request.getSession();
				sesion.setAttribute("usuario", u.getUsuario());
				result ="/Menu.jsp";
			}else{
				result = "/login.jsp";
			}
		
		} else{
			result = "/login.jsp";
		}
		
		rd = getServletContext().getRequestDispatcher(result);
		rd.forward(request, response);
		
		
	}

}
