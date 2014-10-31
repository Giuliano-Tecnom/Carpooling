package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clases.Mensaje;
import clases.Usuario;
import clasesDAO.MensajeDAO;
import clasesDAO.UsuarioDAO;
import clasesqueImplementan.FactoryDAO;

/**
 * Servlet implementation class ServletGuardar
 */
@WebServlet("/ServletGuardar")
public class ServletGuardar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGuardar() {
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
		MensajeDAO mDAO = FactoryDAO.getMensajeDAO();
		Mensaje m = new Mensaje();
		
		String nombreUsuario = (String) request.getSession().getAttribute("usuario");
		Usuario u = uDAO.encontrar(nombreUsuario);
		
		
		m.setMensaje(request.getParameter("mensaje"));
		m.setIdUsuario(u.getIdUsuario());
		mDAO.guardar(m);
		
		
		rd = getServletContext().getRequestDispatcher("/visualizarMensajes.jsp");
		rd.forward(request, response);
	}

}
