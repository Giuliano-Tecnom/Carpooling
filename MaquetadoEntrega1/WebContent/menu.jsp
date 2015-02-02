<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="modelo.Usuario" import="javax.servlet.http.HttpServletRequest" import="javax.servlet.http.HttpSession" 
    import="org.apache.struts2.ServletActionContext" import="com.opensymphony.xwork2.ActionContext" import="com.opensymphony.xwork2.ActionSupport"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@include file="/heder.jsp" %>

<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> <span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<span class="titulo" style="cursor: context-menu;">Auto Log</span>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
					<a href="#" class="dropdown-toggle"	data-toggle="dropdown">
						<% 
						String usuario = null;
						Usuario usuarioEntity = null;
						HttpServletRequest req = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST );
						HttpSession sesion = req.getSession(true);
						if(sesion.getAttribute("usuarioAdministrador") != null){
							usuarioEntity = (Usuario)sesion.getAttribute("usuarioAdministrador");
							usuario = ((Usuario)sesion.getAttribute("usuarioAdministrador")).getNombre();
						} else if(sesion.getAttribute("usuarioViajero") != null){
							usuarioEntity = (Usuario)sesion.getAttribute("usuarioViajero");
							usuario = ((Usuario)sesion.getAttribute("usuarioViajero")).getNombre();
						}else{
						%>
							<jsp:forward page="index.jsp" />
						<%
						}%>
						<span>Hola 
							<%=
								usuario
							%>
						</span> 
						<span class="glyphicon glyphicon-chevron-down"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="login" onclick="alert('Funcionalidad aun no implementada')">Mi Configuraci&oacute;n</a></li>
							<li><a href="cerrarSesion">Cerrar Sesión</a></li>
						</ul>
					</li>
				</ul>
				<form class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="Buscar">
				</form>
			</div>
		</div>
	</div>
