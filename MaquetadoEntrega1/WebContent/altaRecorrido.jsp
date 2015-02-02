
<%@include file="/hederViajero.jsp" %>

<script type="text/javascript" src="js/googleMaps.js">
</script>	 

<script>


function selectEvento(id){
	document.getElementById("idEventoAcademico").setAttribute("value",id);
	//document.getElementById("idEventoAcademico").getAttribute("idEventoAcademicoSeleccionado")
};

</script>
<div class="col-sm-8">	
	<ol class="breadcrumb">
        <li><a href="listadoMisRecorridos">Listado</a></li>
        <li class="active">Alta</li>
    </ol>
    <form class="form-horizontal" action="altaRecorrido" method="post" role="form">
	<div class="panel panel-default clearfix">
	  		<div class="panel-heading clearfix">   			 
	  				<span style="font-size: 24px;">Seleccione el evento/congreso al que desea asistir</span>
	  		</div>
	  		<div class="panel-body"> 	   
								
					<table class="table table-striped">
 					<thead>
			            <tr>
			                <th>ID</th>
			                <th>Nombre</th>
			                <th>Tipo</th>            
			                <th>Telefono</th>
			                <th>Ubicaci&oacute;n </th>
			                <th>Fecha</th>          
			                          
			                <th style="text-align:center;">Acciones</th>
			            </tr>
			        </thead>
			        <tbody>
			            <s:iterator value="eventos" >
				            <tr>
				                <td>
				                	<s:property value="id"></s:property>
			                	</td>               
				                <td>
			                		<s:property value="nombre"></s:property>
			                	</td>
				                <td><s:property value="tipo"></s:property></td>
				                <td><s:property value="telefono"></s:property></td>			                
				                <td><s:property value="direccion"></s:property></td>
				                <td><s:property value="fechaInicio"></s:property></td>			                         
				                <td style="text-align:center;">
				                	<input type="radio" id="evento" name="evento" onchange="selectEvento('<s:property value='id'></s:property>')" />
				                </td>
				            </tr>
			            </s:iterator>
			        </tbody>    
				</table>
			</div>
		</div>
	<div class="panel panel-default clearfix">
	  		<div class="panel-heading clearfix">   			 
	  				<span style="font-size: 24px;">Datos Generales</span>
	  		</div>
	  		<div class="panel-body"> 				
				
					<input type="hidden" name="idEventoAcademicoSeleccionado" id="idEventoAcademico" />
					
					
					<div class="form-group">
			           <div class="col-sm-3">
			           		<label for="registroViaje">Registra el viaje como:</label>
			           </div>
			           <div class="col-sm-9">
			           		<select class="form-control" name="registoViajeComo" id="registroViaje" required>
				     			 <option value="CONDUCTOR">Conductor</option>
							     <option value="PASAJERO">Pasajero</option>
							     <option value="AMBOS">Ambos</option>
		  			   		</select>
			           </div>
			        </div>
			        <div class="form-group">
			         	<div class="col-sm-3">
			         		<label for="tipoViaje">Tipo de viaje:</label>
			         	</div>
			         	<div class="col-sm-9">
			         		<div class="col-sm-2">
			         			<label for="diario">Diario:</label>
			         		</div>
			         		<div class="col-sm-1">
			         			<input type="radio" id="diario" name="tipoViaje" value="DIARIO" checked/>
			         		</div>
			         		<div class="col-sm-2">
			         			<label for="periodico">Per&iacute;odico:</label>
			         		</div>
			         		<div class="col-sm-1">
			         			<input type="radio" id="periodico" name="tipoViaje" value="PERIODICO"/>
			         		</div>
			         		<div class="col-sm-2">
			         			<label for="puntual">Puntual:</label>
			         		</div>
			         		<div class="col-sm-1">
			         			<input type="radio" id="puntual" name="tipoViaje" value="PUNTUAL"/>
			         		</div>
			         	</div>
			        </div>
			        <div class="form-group">
			        	<div class="col-sm-3">
			        		<label for="fechaSalida">Fecha de salida</label>
			        	</div>
			        	<div class="col-sm-9">
			        		<input type="date" name="fechaSalida" class="form-control" id="fechaSalida" required>
			        	</div>
			        </div>
			        <div class="form-group">
			        	<div class="col-sm-3">
			        		<label for="fechaVuelta">Fecha de vuelta</label>
			        	</div>
			        	<div class="col-sm-9">
			        		<input type="date" name="fechaVuelta" class="form-control" id="fechaVuelta" required>
			        	</div>
			        </div>
<!-- 			        <div class="form-group"> -->
<!-- 				        <div class="col-sm-3"> -->
<!-- 				        	<label for="periodico">¿Es un viaje de ida o de ida/vuelta ?</label> -->
<!-- 				        </div> -->
<!-- 				        <div class="col-sm-9"> -->
<!-- 				        	<div class="col-sm-2"> -->
<!-- 					        	<label for="si">Si:</label> -->
<!-- 					        </div> -->
<!-- 					        <div class="col-sm-1"> -->
<!-- 					        	<input type="radio" id="si" name="IdaVuelta" value="IdaVuelta"/> -->
<!-- 				        	</div> -->
<!-- 				        	<div class="col-sm-2"> -->
<!-- 				        		<label for="no">No:</label> -->
<!-- 				        	</div> -->
<!-- 				        	<div class="col-sm-1"> -->
<!-- 				        		<input type="radio" id="no" name="IdaVuelta" value="Ida" /> -->
<!-- 				        	</div> -->
<!-- 				        </div> -->
<!-- 			        </div> -->
			        <div class="form-group">
			        	<div class="col-sm-3">
			        		<label for="horaPartida">Hora de partida:</label>
			        	</div>
			        	<div class="col-sm-9">
			        		<input type="time" class="form-control" name="horaPartida" id="horaPartida" required>
			        	</div>
			        </div>
			        <div class="form-group">
			        	<div class="col-sm-3">
			        		<label for="horaRegreso">Hora de regreso:</label>
			        	</div>
			        	<div class="col-sm-9">
			        		<input type="time" class="form-control" name="horaRegreso" id="horaRegreso" required>
			        	</div>
			        </div>
			        <div class="form-group">
			        	<div class="col-sm-3">
			        		<label for="direccionInicio">Direcci&oacute;n de inicio del recorrido:</label>
			        	</div>
			        	<div class="col-sm-9">
			        		<input type="text" id="direccionInicio" name="direccionInicio" class="form-control" required/>
			        	</div>
			        </div>
			        <div class="form-group">
			        	<div class="col-sm-3">
			        		<label for="direccionFin">Direcci&oacute;n de llegada del recorrido:</label>
			        	</div>
			        	<div class="col-sm-9">
			        		<input type="text" id="direccionFin" name="direccionFin" class="form-control" required/>
			        	</div>
			        </div>
			        <div class="form-group">
			        	<div class="col-sm-3">
			        		<label for="asientosDisponibles">Asientos disponibles:</label>
			        	</div>
			        	<div class="col-sm-9">
			        		<input type="number" id="asientosDisponibles" name="asientosDisponibles" class="form-control" required/>
			        	</div>
			        </div>
			</div>	
	</div>
	<button type="submit" class="btn btn-success btn-block">Guardar</button>
	<br />
	<br />
</form>	
</div>

