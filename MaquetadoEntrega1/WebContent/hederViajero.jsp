<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file="heder.jsp" %>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> <span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="indexAdmin">Auto Log</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
					<a href="#" class="dropdown-toggle"	data-toggle="dropdown">Hola Viajero 
						<span class="glyphicon glyphicon-chevron-down"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="#">Mi Configuración</a></li>
							<li><a href="Inicio?p=logout">Cerrar Sesión</a></li>
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
                          <a href="indexViajero.jsp">Principal </a>  
                      </li>                      
                      <li>  
                          <a href="nuevoRecorrido.jsp"> Agregar Nuevo Recorrido </a>  
                      </li>  
                      <li>  
                          <a href="recorridosPropios.jsp">  Recorridos propios </a>  
                      </li>                           
                       <li>  
                          <a href="recorridosOtros.jsp"> Recorridos de otros </a>  
                      </li>     
                      <li>  
                          <a href="calificarUsuarios.jsp"> Calificar Usuarios </a>  
                      </li>   
                      <li>  
                          <a href="mensajes.jsp">Mensajes</a>  
                      </li>                
                </ul>
            </div>            
            
           
    


