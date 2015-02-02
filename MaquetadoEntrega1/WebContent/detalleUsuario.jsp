<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@include file="/hederViajero.jsp" %>	 

<div class="col-sm-8 ">
    <ol class="breadcrumb">
        <li><a href="listadoMisRecorridos">Listado</a></li>
        <li>
	        <s:url var="myurl" action="listadoDeSolicitudesDeParticipacionAlRecorrido">
				<s:param name="id">
					<s:property value="recorridoEntity.id"></s:property>
				</s:param>
			</s:url>
			<s:a href="%{myurl}">
				 Solicitudes
			</s:a> 
        </li>
        <li>Detalle usuario</li>
    </ol>
    <div class="panel panel-default clearfix">
  		<div class="panel-heading clearfix">   			 
  				<span style="font-size: 24px;">Detalle del usuario <s:property value="usuarioEntity.usuario"></s:property></span>
  				
  		</div>	
  		<div class="panel-body"> 	   
			<div class="form-horizontal">
				<div class="form-group">
					<div class="col-sm-12">
						<label>Nombre:</label>&nbsp;<s:property value="usuarioEntity.nombre"></s:property><br>
						<label>Apellido:</label>&nbsp;<s:property value="usuarioEntity.apellido"></s:property><br>
						<label>Direcci&oacute;n:</label>&nbsp;<s:property value="usuarioEntity.direccion"></s:property><br>
						<label>N&uacute;mero de documento:</label>&nbsp;<s:property value="usuarioEntity.dni"></s:property><br>
						<label>Telefono:</label>&nbsp;<s:property value="usuarioEntity.telefono"></s:property><br>
						<label>Email:</label>&nbsp;<s:property value="usuarioEntity.email"></s:property><br>
						<label>Foto:</label>&nbsp;<br>
						<label>Denuncias recibidas:</label>&nbsp;<br>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>