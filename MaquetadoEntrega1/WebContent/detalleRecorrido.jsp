<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@include file="/hederViajero.jsp" %>
<script>
$(document).ready( function () {
    $('#table_id').DataTable();
    console.log("Entro al js");
} );
</script>
<ol class="breadcrumb col-sm-8">
   <li>
   		<%
   		String dondeViene =  req.getParameter("v") ;
   			if(dondeViene.equals("M")){%>
   				<a href="listadoMisRecorridos">Listado</a>
   		<%	}else{%>
   				<a href="listadoEventosCongresos">Listado</a><%
  			}%>
   		
  	</li>
   <li class="active">Detalle</li>
</ol>

<div class="col-sm-8">  
   	<div class="panel panel-default">
		    <div class="panel-heading clearfix">
		    	<span style="font-size: 24px;">Detalle del recorrido a: <s:property value="recorrido.evento.nombre"></s:property>
		    		<s:property value="evento.nombre"></s:property>
	    		</span> 
		    </div>
		    <div class="panel-body clearfix">
		    	<div class="col-sm-6">
		    		<h3>Datos del Evento</h3>
		    		<label>Nombre:</label>&nbsp;<s:property value="recorrido.evento.nombre"></s:property><br>
		    		<label>Telefono:</label>&nbsp;<s:property value="recorrido.evento.telefono"></s:property><br>
		    		<label>Direcci&oacute;n:</label>&nbsp;<s:property value="recorrido.evento.direccion"></s:property><br>
		    		<label>Fecha de creaci&oacute;n:</label>&nbsp;<s:property value="recorrido.evento.fechaDeCreacion"></s:property><br>
		    		<label>Fecha de inicio:</label>&nbsp;<s:property value="recorrido.evento.fechaInicio"></s:property><br>
		    		<label>Fecha de fin:</label>&nbsp;<s:property value="recorrido.evento.fechaFin"></s:property><br>
		    		<label>Hora de apertura y de cierre:</label>&nbsp;<s:property value="recorrido.evento.horaDesdeHasta"></s:property><br>
		    		<label>Tipo:</label>&nbsp;<s:property value="recorrido.evento.tipo"></s:property><br>
		    	</div>
		    	<div class="col-sm-6">
		    		<h3>Datos generales</h3>
			    	<label>Direcci&oacute;n desde donde se comienza el recorrido:</label>&nbsp;<s:property value="recorrido.direccionDesde"></s:property><br>
			    	<label>Direcci&oacute;n hasta donde se finaliza el recorrido:</label>&nbsp;<s:property value="recorrido.direccionHasta"></s:property><br>
			    	<label>Recorrido en google Maps:</label>&nbsp;<br>
			    	
			    	<label>Fecha de salida:</label>&nbsp;<s:property value="recorrido.fechaSalida"></s:property><br>
			    	<label>Fecha de vuelta:</label>&nbsp;<s:property value="recorrido.fechaVuelta"></s:property><br>
			    	<label>Hora de Partida:</label>&nbsp;<s:property value="recorrido.horaPartida"></s:property><br>
			    	<label>Hora estimada de llegada:</label>&nbsp;<s:property value="recorrido.horaLlegada"></s:property><br>
			    	<label>Cantidad de asientos disponibles:</label>&nbsp;<s:property value="recorrido.asientosDisponibles"></s:property><br>
		    	</div>
		    	<div class="col-sm-12">
		    		<h3>Miembros del recorrido</h3>
			    	<s:if test="recorrido.integrantesDelRecorrido.size == 0">
			    		<span>No posee miembros unidos al recorrido</span>
			    	</s:if>
			    	<s:else>
				    	<table class="table table-striped display" id="table_id">
							<thead>
					            <tr>       
					                <th>Nombre</th>  
					                <th>Apellido</th>
					                <th>Telefono</th>
					                <th>DNI</th>
					                <th>Denuncias</th> 
					                <th style="width:166px;">Acciones</th>			              
					            </tr>
				            </thead>
				            <tbody>
				            	<s:iterator value="recorrido.integrantesDelRecorrido" >
				            	<tr>
				            		<td>
				            			<s:property value="nombre"></s:property>
				            		</td>
				            		<td>
				            			<s:property value="apellido"></s:property>
				            		</td>
				            		<td>
				            			<s:property value="telefono"></s:property>
				            		</td>
				            		<td>
				            			<s:property value="dni"></s:property>
				            		</td>
				            		<td>
				            			<a onclick="alert('Funcionalidad aun no implementada')" style="cursor:pointer;">(Ver)</a>
			            			</td>
				            		<td>
				            			<s:url id="myurl" action="eliminarUsuarioRecorrido">
											<s:param name="idUsuario">
												<s:property value="id"></s:property>
											</s:param>
											<s:param name="idRecorrido">
												<s:property value="recorrido.id"></s:property>
											</s:param>
										</s:url>
										<s:a href="%{myurl}">
											<span class="btn btn-danger">Eliminar</span>
										</s:a>
				            			<a class="btn btn-success" onclick="alert('Funcionalidad aun no implementada')">Puntuar</a>
				            		</td>
				            	</tr>
				            	</s:iterator>	
				            </tbody>
			            </table>
		            </s:else>
		    	</div>
		    </div>
	 </div>
</div>	 