<%@taglib uri="/struts-tags" prefix="s"%>
<%@include file="/hederViajero.jsp" %>	 
<script>
$(document).ready( function () {
    $('#table_id').DataTable();
    console.log("Entro al js");
} );
</script>	 	 
	 
<div class="col-sm-8">
<ol class="breadcrumb">
   <li class="active">Listado</li>
</ol>
   	<div class="panel panel-default clearfix">
  		<div class="panel-heading clearfix">   			 
  			<span style="font-size: 24px;">Recorridos a eventos/congresos</span>
  		</div>	
  		<div class="panel-body"> 	   
			
			<table class="table table-striped" id="table_id">
				<thead>
		            <tr>          
		                <th>ID</th>
		                <th>Tipo Viaje</th>  
		                <th>Evento/Congreso</th>
		                <th>Fecha de salida</th> 
		                <th>Asientos Disponibles</th>
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
										T
									</s:param>
								</s:url>
								<s:a href="%{myurl}">
									<s:property value="recorrido.id"></s:property>
								</s:a>
							</td>
							<td>
								<s:property value="recorrido.tipo"></s:property>
							</td>
							<td>
								<s:property value="recorrido.evento.nombre"></s:property>
							</td>
							<td>
								<s:property value="recorrido.fechaSalida"></s:property>
							</td>
							<td>
								<s:property value="recorrido.asientosDisponibles"></s:property>
							</td>
							<th>
							
								<s:if test="recorrido.asientosDisponibles > 0 && !recorrido.solicitaronUnirseAlRecorrido.contains(usuarioLogueado) && !recorrido.integrantesDelRecorrido.contains(usuarioLogueado)">
									<s:url var="myurl" action="participarDelRecorrido">
									<s:param name="id">
										<s:property value="recorrido.id"></s:property>
									</s:param>
									</s:url>
									<s:a href="%{myurl}">
										<span class="btn btn-success btn-block">Participar</span>
									</s:a>
								</s:if>
								<s:elseif test="recorrido.asientosDisponibles == 0 && !recorrido.solicitaronUnirseAlRecorrido.contains(usuarioLogueado) && !recorrido.integrantesDelRecorrido.contains(usuarioLogueado)">
									<span>Recorrido lleno</span>
								</s:elseif>
								<s:elseif test="recorrido.solicitaronUnirseAlRecorrido.contains(usuarioLogueado)">
									<s:url var="myurl2" action="darseDeBajaDelRecorrido">
									<s:param name="id">
										<s:property value="recorrido.id"></s:property>
									</s:param>
									</s:url>
									<s:a href="%{myurl2}">
										<span class="btn btn-warning btn-block">Darse de baja</span>
									</s:a>
								</s:elseif>
								<s:else>
									<s:url var="myurl3" action="cancelarSuscripcionRecorrido">
									<s:param name="id">
										<s:property value="recorrido.id"></s:property>
									</s:param>
									</s:url>
									<s:a href="%{myurl3}">
										<span class="btn btn-danger btn-block">Cancelar suscripci&oacute;n</span>
									</s:a>
								</s:else>
								
							</th>
						</tr>
					</s:iterator>
	            </tbody>
           </table>
        </div>
   	</div>
</div>
	 