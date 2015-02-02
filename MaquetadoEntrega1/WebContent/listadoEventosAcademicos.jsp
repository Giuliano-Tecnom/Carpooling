<%@taglib uri="/struts-tags" prefix="s"%>
<%@include file="/hederAdmin.jsp" %>	 
<script>
$(document).ready( function () {
    $('#table_id').DataTable();
    console.log("Entro al js");
} );

function borrar(){
	var x;
	var r = confirm("Está seguro que desa borrar el evento?");
	if (r == true) {
	    x = "You pressed OK!";
	    
	} else {
	    x = "You pressed Cancel!";
	}
	
}
</script>	 
	 
	<ol class="breadcrumb col-sm-8 ">
        <li class="active">Listado</li>
    </ol>
	
	<div class="col-sm-8 "> 
	<div class="panel panel-default clearfix">
  		<div class="panel-heading clearfix">   			 
  				<span style="font-size: 24px;">Eventos/Congresos Academicos</span>
  			 	<a class="btn btn-success pull-right" href="altaEventoAcademico.jsp">Nuevo Evento</a>			 
  			 
  		</div>		
		<div class="panel-body"> 	   
  				<table class="table table-striped" id="table_id">
 					<thead>
			            <tr>
			                <th>ID</th>
			                <th>Nombre</th>
			                <th>Tipo</th>            
			                <th>Telefono</th>
			                <th>Direcci&oacute;n</th>
			                <th>Fecha</th>          
			                          
			                <th style="width:166px;">Acciones</th>
			            </tr>
			        </thead>
			        <tbody>
			            <s:iterator value="eventos" >
			            <tr>
			                <td><s:property value="id"></s:property></td>
			                
			                		                
			                <td>
		                		<s:url id="myurl" action="detailEventoAcademico">
									<s:param name="id">
										<s:property value="id"></s:property>
									</s:param>
								</s:url>
								<s:a href="%{myurl}">
									<s:property value="nombre"></s:property>
								</s:a>
		                	</td>
			                <td><s:property value="tipo"></s:property></td>
			                <td><s:property value="telefono"></s:property></td>			                
			                <td><s:property value="direccion"></s:property></td>
			                <td><s:property value="fechaInicio"></s:property></td>			                         
			                <td>
			                  
				                <s:url id="myurl2" action="editarEventoAcademico">
									<s:param name="id">
										<s:property value="id"></s:property>
									</s:param>
								</s:url>
								<s:a href="%{myurl2}">
									<span  class="btn btn-warning">Editar</span>
								</s:a>
								
								<s:url id="myurl3" action="borrarEventoAcademico">
									<s:param name="id">
										<s:property value="id"></s:property>
									</s:param>
								</s:url>
								<s:a href="%{myurl3}" onclick="borrar()">
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
