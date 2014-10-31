<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="clasesDAO.MensajeDAO"%>
  <%@ page import="clasesDAO.UsuarioDAO"%>
   <%@ page import="clases.Usuario"%>
  <%@ page import="clasesqueImplementan.FactoryDAO"%>
  <%@ page import="java.util.List"%>
  <%@ page import="clases.Mensaje" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Listado de mensajes</h3>
<ul>
<% 
	MensajeDAO mDAO = FactoryDAO.getMensajeDAO();
	UsuarioDAO uDAO = FactoryDAO.getUsuarioDAO();
	List<Mensaje> l = mDAO.cargar();
	for(int i=0 ; i < l.size(); i++){ %>
		<li><%=l.get(i).getMensaje()%></li>
		
	<%}%>
	</ul>
	<input type="button" value="Menu Principal" onClick="location.href ='Menu.jsp'"> <br>
</body>
</html>