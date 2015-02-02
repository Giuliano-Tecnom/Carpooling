<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@include file="/hederViajero.jsp" %>	 

<script>
$(document).ready( function () {
    $('#table_id').DataTable();
    console.log("Entro al js");
} );
</script>	

<div class="col-sm-8 ">
    <ol class="breadcrumb">
        <li><a href="listadoMisRecorridos">Listado</a></li>
        <li>Solicitudes</li>
    </ol>
    <div class="panel panel-default clearfix">
  		<div class="panel-heading clearfix">   			 
  				<span style="font-size: 24px;">Usuarios que solicitaron unirse al recorrido</span>
  		</div>	
  		<div class="panel-body"> 	   
			<form class="form-horizontal" role="form">
				<div class="form-group">					
					<div class="col-sm-1">
						<label for="filtro">Filtro:</label>
					</div>			
					<div class="col-sm-11">
						<input type="text" id="filtro" class="form-control"/>
					</div>
				</div>
			</form>
			
			<table class="table table-striped" id="table_id">
				<thead>
		            <tr> 
		            	<th>ID</th>         
		                <th>Nombre de suario</th>  
		                <th>Telefono</th>
		                <th>Direcci&oacute;n</th>
		                <th>Email</th>
		                <th style="width:193px;">Acciones</th>			              
		            </tr>
	            </thead>
	            <tbody>
					<s:iterator value="usuarios" >
					<tr>
						<td>
							<s:url var="myurl2" action="detalleUsuario">
								<s:param name="idUsuario">
									<s:property value="id"></s:property>
								</s:param>
								<s:param name="idRecorrido">
									<s:property value="recorrido.id"></s:property>
								</s:param>
							</s:url>
							<s:a href="%{myurl2}">
								<s:property value="id"></s:property>
							</s:a>
						</td>
						<td><s:property value="usuario"></s:property></td>
						<td>
							<s:property value="telefono"></s:property>
						</td>
						<td>
							<s:property value="direccion"></s:property>
						</td>
						<td>
							<s:property value="email"></s:property>
						</td>
						<td>
							<s:url var="myurl" action="incluirUsuarioAlRecorrido">
								<s:param name="idRecorrido">
									<s:property value="recorrido.id"></s:property>
								</s:param>
								<s:param name="idUsuario">
									<s:property value="id"></s:property>
								</s:param>
							</s:url>
							<s:a href="%{myurl}">
								<span class="btn btn-success">Agregar</span>
							</s:a>
							<s:url var="myurl3" action="rechazarUsuarioDelRecorrido">
								<s:param name="idRecorrido">
									<s:property value="recorrido.id"></s:property>
								</s:param>
								<s:param name="idUsuario">
									<s:property value="id"></s:property>
								</s:param>
							</s:url>
							<s:a href="%{myurl3}">
								<span class="btn btn-danger">Rechazar</span>
							</s:a>
						</td>
					</tr>
					</s:iterator>		            
	            </tbody>
           </table>
        </div>
   	</div>
   	<div class="panel panel-default clearfix">
   		<div class="panel-heading clearfix">   			 
  				<span style="font-size: 24px;">Detalle del recorrido a <s:property value="recorrido.evento.nombre"></s:property></span>
  		</div>	
  		<div class="panel-body"> 	   
			<div class="form-horizontal">
				<div class="form-group">
					<div class="col-sm-12">
						<label>Nombre:</label>&nbsp;<s:property value="recorrido.evento.nombre"></s:property><br>
			    		<label>Telefono:</label>&nbsp;<s:property value="recorrido.evento.telefono"></s:property><br>
			    		<label>Direcci&oacute;n:</label>&nbsp;<s:property value="recorrido.evento.direccion"></s:property><br>
			    		<label>Fecha de creaci&oacute;n:</label>&nbsp;<s:property value="recorrido.evento.fechaDeCreacion"></s:property><br>
			    		<label>Fecha de inicio:</label>&nbsp;<s:property value="recorrido.evento.fechaInicio"></s:property><br>
			    		<label>Fecha de fin:</label>&nbsp;<s:property value="recorrido.evento.fechaFin"></s:property><br>
			    		<label>Hora de apertura y de cierre</label>&nbsp;<s:property value="recorrido.evento.horaDesdeHasta"></s:property><br>
			    		<label>Tipo:</label>&nbsp;<s:property value="recorrido.evento.tipo"></s:property><br>
<!-- 				    	<h3>Datos generales</h3> -->
				    	<label>Direcci&oacute;n desde donde se comienza el recorrido:</label>&nbsp;<s:property value="recorrido.direccionDesde"></s:property><br>
				    	<label>Direcci&oacute;n hasta donde se finaliza el recorrido:</label>&nbsp;<s:property value="recorrido.direccionHasta"></s:property><br>
				    	<label>Recorrido en google Maps:</label>&nbsp;<br>
				    	<label>Fecha de salida:</label>&nbsp;<s:property value="recorrido.fechaSalida"></s:property><br>
				    	<label>Fecha de vuelta:</label>&nbsp;<s:property value="recorrido.fechaVuelta"></s:property><br>
				    	<label>Hora de Partida:</label>&nbsp;<s:property value="recorrido.horaPartida"></s:property><br>
				    	<label>Hora estimada de llegada:</label>&nbsp;<s:property value="recorrido.horaLlegada"></s:property><br>
				    	<label>Cantidad de asientos disponibles:</label>&nbsp;<s:property value="recorrido.asientosDisponibles"></s:property><br>
					</div>
				</div>	
			</div>
		</div>
   	</div>				
</div>