<%@include file="/hederAdmin.jsp" %>	 
	 <div class="col-sm-8 panel panel-default">
  				<ol class="breadcrumb">
			        <li>Viajes</li>
			        <li>Listado</li>
			        <li class="active">Nuevo</li>
			    </ol>
			    <h1 class="page-header">Alta Viaje
			        <a class="btn btn-info" style="float:right;" href="listadoViajes.jsp">Volver</a>
			    </h1>
  				<form role="form" style="margin-bottom: 4%">
					  <div class="form-group">
					    <label for="evento">Evento</label>
					    <input type="text" class="form-control" id="evento" placeholder="Nombre del Evento">
					  </div>
					  <div class="form-group">
					    <label for="desde">Desde</label>
					    <input type="text" class="form-control" id="desde" placeholder="Lugar de Partida">
					  </div>
					   <div class="form-group">
					    <label for="hasta">Hasta</label>
					    <input type="text" class="form-control" id="hasta" placeholder="Lugar de Llegada">
					  </div>
					  <div class="form-group">
					    <label for="fechaHora">Fecha y hora</label>
					    <input type="datetime" class="form-control" id="fechaHora" placeholder="Fecha y hora de partida">
					  </div>
					  <div class="form-group">
					    <label for="lugares">Cantidad de lugares disponibles en el vehiculo</label>
					    <input type="number" class="form-control" id="lugares" placeholder="Cantidad de lugares disponibles en el vehiculo">
					  </div>	
					   <div class="form-group">
					    <label for="telefono">Telefono Conductor</label>
					    <input type="tel" class="form-control" id="telefono" placeholder="Telefono del conductor">
					  </div>	
					  <div class="form-group">
					    <label for="cantHoras">Cantidad de horas estimadas de viaje</label>
					    <input type="number" class="form-control" id="telefono" placeholder="Cantidad de horas estimadas de viaje">
					  </div>  
					  <div class="form-group">
					    <label for="precio">Precio total del viaje</label>
					    <input type="number" class="form-control" id="telefono" placeholder="Precio total del viaje">
					  </div>
					  
					  <button type="submit" class="btn btn-success">Guardar</button>
					</form>
		</div>
			
		</div>
    </div>