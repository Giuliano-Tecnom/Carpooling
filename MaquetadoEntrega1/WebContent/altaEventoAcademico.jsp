<%@include file="/hederAdmin.jsp"%>

<script type="text/javascript" src="js/googleMaps.js">
</script>

<ol class="breadcrumb col-sm-8">
	<li><a href="listadoEventosAcademicos">Listado</a></li>
	<li class="active">Nuevo</li>
</ol>
<div class="col-sm-8">
	<div class="panel panel-default">
		<div class="panel-heading clearfix">
			<span style="font-size: 24px;">Alta de evento</span> 
		</div>
		<div class="panel-body">
			<form role="form" action="altaEventoAcademico" method="post"
				style="margin-bottom: 4%">
				<div class="form-group">
					<label for="evento">Nombre del evento</label> <input type="text"
						class="form-control" id="evento" name="nombre"
						placeholder="Nombre del Evento" required>
				</div>

				<div class="form-group">
					<label for="telefono">Telefono</label> <input type="tel"
						class="form-control" id="telefono" name="telefono"
						placeholder="Telefono de comunicaci&oacute;n con el evento"
						required>
				</div>
				<div class="form-group">
					<label for="dir">Direcci&oacute;n</label> <input type="text"
						class="form-control" id="dir" name="direccion"
						placeholder="Direcci&oacute;n del evento" onblur="eligioDireccion()" required>
				</div>
				<div class="form-group">
					<label for="fechaini">Fecha de inicio</label> <input type="date"
						class="form-control" id="fechaini" name="fechaInicio"
						placeholder="Fecha programada para el comienzo del evento"
						required>
				</div>
				<div class="form-group">
					<label for="fechafin">Fecha de fin</label> <input type="date"
						class="form-control" id="fechafin" name="fechaFin"
						placeholder="Fecha programad para el cierre del evento" required>
				</div>
				<div class="form-group">
					<label for="hora">Hora de atenci&oacute;n</label> <input
						type="text" class="form-control" id="hora" name="horaDesdeHasta"
						placeholder="Hora desde - Hora Hasta, ejemplo: 8:00 - 16:00"
						required>
				</div>
				<div class="form-group">
					<label for="tipo">Tipo de evento</label> <select name="tipo"
						class="btn btn-default btn-block" required>
						<option value="CONGRESO">Congreso</option>
						<option value="ACADEMICO">Evento academico</option>
					</select>
				</div>
				
				<div class="form-group" id="mapa">
					<label>Ubicaci&oacute;n en mapa:</label><br/>
					<div id="map_canvas" style="width: 100%; height: 500px">
					</div>
				</div>

				<button type="submit" class="btn btn-success btn-block">Guardar</button>
			</form>
		</div>


	</div>

</div>
