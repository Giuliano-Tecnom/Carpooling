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
        <li class="active">Listado</li>
    </ol>
    	<div class="panel panel-default clearfix">
	  		<div class="panel-heading clearfix">   			 
	  				<span style="font-size: 24px;">Mis Recorridos</span>
	  			 	<a class="btn btn-success pull-right" href="nuevoRecorrido">Nuevo Recorrido</a>		
	  		</div>	
	  		<div class="panel-body"> 	
				<table class="table table-striped display" id="table_id">
					<thead>
			            <tr> 
			            	<th>ID</th>         
			                <th>Tipo Viaje</th>  
			                <th>Evento</th>
			                <th>Fecha de Salida</th>
			                <th>Asientos</th> 
			                <th>Solicitudes</th> 
			                <th style="width:166px;">Acciones</th>			              
			            </tr>
		            </thead>
		            <tbody>
						<s:iterator value="recorridosRealizados" >
						<tr>
							<td>
								<s:url id="myurl" action="detailRecorrido">
									<s:param name="id">
										<s:property value="recorrido.id"></s:property>
									</s:param>
									<s:param name="v">
										M
									</s:param>
								</s:url>
								<s:a href="%{myurl}">
									<s:property value="recorrido.id"></s:property>
								</s:a>
							</td>
							<td><s:property value="recorrido.tipo"></s:property></td>
							<td>
								<s:property value="recorrido.evento.nombre"></s:property>
							</td>
							<td>
								<s:property value="recorrido.fechaSalida"></s:property>
							</td>
							<td>
								<s:property value="recorrido.asientosDisponibles"></s:property>
							</td>
							<td>
								<s:if test="recorrido.solicitaronUnirseAlRecorrido.size > 0">
									<s:url var="myurl" action="listadoDeSolicitudesDeParticipacionAlRecorrido">
									<s:param name="id">
										<s:property value="recorrido.id"></s:property>
									</s:param>
									</s:url>
									<s:if test="recorrido.solicitaronUnirseAlRecorrido.size == 1">
										<s:a href="%{myurl}">
											<span><s:property value="recorrido.solicitaronUnirseAlRecorrido.size"></s:property> solicitud </span>
										</s:a>
									</s:if>
									<s:else>
										<s:a href="%{myurl}">
											<span><s:property value="recorrido.solicitaronUnirseAlRecorrido.size"></s:property> solicitudes </span>
										</s:a>
									</s:else>
								</s:if>
								<s:else>
									<span>Ninguna</span>
								</s:else>
							</td>
							<td>
								<s:url id="myurl3" action="editarRecorrido">
									<s:param name="id">
										<s:property value="recorrido.id"></s:property>
									</s:param>
								</s:url>
								<s:a href="%{myurl3}">
									<span  class="btn btn-warning">Editar</span>
								</s:a> 
								<s:url id="myurl2" action="eliminarRecorrido">
									<s:param name="id">
										<s:property value="recorrido.id"></s:property>
									</s:param>
								</s:url>
								<s:a href="%{myurl2}">
									<span  class="btn btn-danger">Eliminar</span>
								</s:a>  
			                	
							</td>
						</tr>
						</s:iterator>		            
		            </tbody>
	           </table>
	        </div>
    	</div>
    </div>
    
    
	