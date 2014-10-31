<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  

if(session.getAttribute("usuario") == null){
%>
<jsp:forward page="login.jsp"></jsp:forward>
<%} %>
<form action="">
<input type="button" value="Publicar mensajes" onClick="location.href ='formuMensaje.jsp'"> <br>
<input type ="button" value="Visualizar mensajes" onClick="location.href ='visualizarMensajes.jsp'"> <br>
<input type ="button" value= "Salir" onClick="location.href ='salir.jsp'"><br>
</form>
</body>
</html>