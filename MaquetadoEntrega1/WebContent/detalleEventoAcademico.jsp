<%@taglib uri="/struts-tags" prefix="s"%>
<%@include file="/hederAdmin.jsp" %>	 
	 
	<ol class="breadcrumb col-sm-8">
        <li>Viajes</li>
        <li>Listado</li>
        <li class="active">Detalle</li>
    </ol>
	  <div class="col-sm-8">  
	    	<div class="panel panel-default">
				    <div class="panel-heading clearfix">
				    	<span style="font-size: 24px;">Detalle del evento:
				    		<s:property value="evento.nombre"></s:property>
			    		</span> 
				        <a class="btn btn-info" style="float:right;" href="listadoEventosAcademicos">Volver</a>
				    </div>
				    <div class="panel-body">
				    	<label>Nombre del evento:</label>&nbsp;<s:property value="evento.nombre"></s:property><br>
				    	<label>Telefono:</label>&nbsp;<s:property value="evento.telefono"></s:property><br>
				    	<label>Direcci&oacute;n:</label>&nbsp;<s:property value="evento.direccion"></s:property><br>
				    	<label>Fecha de creaci&oacute;n:</label>&nbsp;<s:property value="evento.fechaDeCreacion"></s:property><br>
				    	<label>Fecha de inicio:</label>&nbsp;<s:property value="evento.fechaInicio"></s:property><br>
				    	<label>Fecha de fin:</label>&nbsp;<s:property value="evento.fechaFin"></s:property><br>
				    	<label>Hora de inicio - Hora de fin:</label>&nbsp;<s:property value="evento.horaDesdeHasta"></s:property><br>
				    	<label>Tipo de evento:</label>&nbsp;<s:property value="evento.tipo"></s:property><br>
				    </div>
			 </div>
	 </div>
			    
			    