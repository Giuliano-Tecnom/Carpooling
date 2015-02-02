
<%@include file="/hederViajero.jsp" %>


<script type="text/javascript" src="js/googleMaps.js">
</script>	 

<script>


function selectEvento(id){
	document.getElementById("idEventoAcademico").setAttribute("value",id);
};

</script>
<div class="col-sm-8">	
	<ol class="breadcrumb">
        <li><a href="listadoMisRecorridos">Listado</a></li>
        <li class="active">Editar</li>
    </ol>
    <form class="form-horizontal" action="updateRecorrido" method="post" role="form">
    	<input type="hidden" name="id" value="<s:property value="id"></s:property>"/>
		<div class="panel panel-default clearfix">
	  		<div class="panel-heading clearfix">   			 
	  				<span style="font-size: 24px;">Evento/Congreso al que va a asistir</span>
	  		</div>
	  		<div class="panel-body"> 	   
								
					<table class="table table-striped">
 					<thead>
			            <tr>
			                <th>ID</th>
			                <th>Nombre</th>
			                <th>Tipo</th>            
			                <th>Telefono</th>
			                <th>Ubicaci&oacute;n</th>
			                <th>Fecha</th>          
			                          
			                <th style="text-align:center;">Acciones</th>
			            </tr>
			        </thead>
			        <tbody>
			            <tr>
			                <td>
			                	<s:property value="recorrido.evento.id"></s:property>
		                	</td>               
			                <td>
		                		<s:property value="recorrido.evento.nombre"></s:property>
		                	</td>
			                <td><s:property value="recorrido.evento.tipo"></s:property></td>
			                <td><s:property value="recorrido.evento.telefono"></s:property></td>			                
			                <td><s:property value="recorrido.evento.direccion"></s:property></td>
			                <td><s:property value="recorrido.evento.fechaInicio" ></s:property></td>			                         
			                <td style="text-align:center;">
			                	<input type="radio" id="evento" name="evento" checked />
			                </td>
			            </tr>
			        </tbody>    
				</table>
			</div>
		</div>
		<div class="panel panel-default clearfix">
	  		<div class="panel-heading clearfix">   			 
	  				<span style="font-size: 24px;">Datos Generales</span>
	  		</div>
	  		<div class="panel-body"> 				
				
				<input type="hidden" name="idEventoAcademicoSeleccionado" id="idEventoAcademico" value="<s:property value="recorrido.evento.id"></s:property>"/>
				<input type="hidden" name="id" value="<s:property value="recorrido.id"></s:property>"/>
				
				<div class="form-group">
		           <div class="col-sm-3">
		           		<label for="registroViaje">Registra el viaje como:</label>
		           </div>
		           <div class="col-sm-9">
		           		<s:select cssClass="form-control" name="registoViajeComo" list="#{'CONDUCTOR':'Conductor','PASAJERO':'Pasajero','AMBOS':'Ambos'}" value="recorrido.tipoDeRegistro" />			           		
		           </div>
		        </div>
		        <div class="form-group">
		         	<div class="col-sm-3">
		         		<label for="tipoViaje">Tipo de viaje:</label>
		         	</div>
		         	<div class="col-sm-9">
		         		<s:select cssClass="form-control" name="tipoViaje" list="#{'DIARIO':'Diario','PERIODICO':'Periodico','PUNTUAL':'Puntual'}" value="recorrido.tipo" />
		         	</div>
		        </div>
		        <div class="form-group">
		        	<div class="col-sm-3">
		        		<label for="fechaSalida">Fecha de salida</label>
		        	</div>
		        	<div class="col-sm-9">
		        		<input type="date" name="fechaSalida" class="form-control" id="fechaSalida" value="<s:property value="fechaSalida"></s:property>">
		        	</div>
		        </div>
		        <div class="form-group">
		        	<div class="col-sm-3">
		        		<label for="fechaVuelta">Fecha de vuelta</label>
		        	</div>
		        	<div class="col-sm-9">
		        		<input type="date" name="fechaVuelta" class="form-control" id="fechaVuelta" value="<s:property value="fechaVuelta"></s:property>">
		        	</div>
		        </div>
		        <div class="form-group">
		        	<div class="col-sm-3">
		        		<label for="horaPartida">Hora de partida:</label>
		        	</div>
		        	<div class="col-sm-9">
		        		<input type="time" class="form-control" name="horaPartida" id="horaPartida" value="<s:property value="horaPartida"></s:property>" >
		        	</div>
		        </div>
		        <div class="form-group">
		        	<div class="col-sm-3">
		        		<label for="horaRegreso">Hora de regreso:</label>
		        	</div>
		        	<div class="col-sm-9">
		        		<input type="time" class="form-control" name="horaRegreso" id="horaRegreso" value="<s:property value="horaRegreso"></s:property>" >
		        	</div>
		        </div>
		        <div class="form-group">
		        	<div class="col-sm-3">
		        		<label for="direccionInicio">Direcci&oacute;n de inicio del recorrido:</label>
		        	</div>
		        	<div class="col-sm-9">
		        		<input type="text" id="direccionInicio" name="direccionInicio" class="form-control" value="<s:property value="recorrido.direccionDesde"></s:property>"/>
		        	</div>
		        </div>
		        <div class="form-group">
		        	<div class="col-sm-3">
		        		<label for="direccionFin">Direcci&oacute;n de llegada del recorrido:</label>
		        	</div>
		        	<div class="col-sm-9">
		        		<input type="text" id="direccionFin" name="direccionFin" class="form-control" value="<s:property value="recorrido.direccionHasta"></s:property>" />
		        	</div>
		        </div>
		        <div class="form-group">
		        	<div class="col-sm-3">
		        		<label for="asientosDisponibles">Asientos disponibles:</label>
		        	</div>
		        	<div class="col-sm-9">
		        		<input type="number" id="asientosDisponibles" name="asientosDisponibles" class="form-control" value="<s:property value="recorrido.asientosDisponibles"></s:property>" />
		        	</div>
		        </div>
			</div>	
		</div>
	
	<button type="submit" class="btn btn-success btn-block">Guardar</button>
	<br />
	<br />
</form>	
</div>