
<%@include file="/hederViajero.jsp" %>
<div class="col-sm-8 panel panel-default">	
	<div class="row" style="margin-top: 4%; margin-left: 6%; margin-right: 60%">
	<h1 class="titulo"> Mensajes</h1>	
	<form role="form" action="indexViajero.jsp" method="post">        
	
	<div class="row">	
	<div class="col-sm-3">	
	        	<input type="text" name="direHasta" placeholder="Mensaje">
	</div>
	<div class="col-sm-8">	
	        	<a class="btn btn-success" style="float:right;" href="altaUsuario.jsp">Enviar</a>
	</div>
	</div>
	
	
	</form>  
	<br></br>
	<div class="form-group">
	<textarea class="form-control" rows="8" cols="8" disabled="disabled">
	-Giuliano: Algun usuario en linea que viaje al CACIC ?

	
	</textarea> 
	</div>    
	
	<div id="usuarios">
	 Usuarios en l&iacute;nea : 11
	</div>
</div>
