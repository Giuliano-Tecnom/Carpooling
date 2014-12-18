<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="modelo.Usuario"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@include file="heder.jsp" %>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> <span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="indexAdmin.jsp">Auto Log</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
					<a href="#" class="dropdown-toggle"	data-toggle="dropdown">
						<span>Hola 
							<%= 
								((Usuario)session.getAttribute("usuarioAdministrador")).getNombre()
							%>
						</span> 
						<span class="glyphicon glyphicon-chevron-down"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="#">Mi Configuración</a></li>
							<li><a href="#">Cerrar Sesión</a></li>
						</ul>
					</li>
				</ul>
				<form class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="Buscar">
				</form>
			</div>
		</div>
	</div>
	<div class="container-fluid"style="margin-top: 5%;">
  		<div class="row">
			<div class="col-sm-3">		
                  <ul class="nav nav-pills nav-stacked" role="navigation">  
                      <li>  
                          <a href="indexAdmin.jsp">Principal </a>  
                      </li>                      
                      <li>  
                          <a href="listadoUsuarios.jsp"> Usuarios </a>  
                      </li>  
                      <li>  
                          <a href="listadoEventosAcademicos"> Eventos / Congresos  </a>  
                      </li>                          
                      <li>  
                          <a href="listadoQuejas.jsp"> Seccion de Quejas </a>  
                      </li>                    
                </ul>
            </div>            
            
           
    


