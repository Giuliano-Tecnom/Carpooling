<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro Viajero</title>
</head>
<body>
	<jsp:include page="heder.jsp"></jsp:include>
	
	<div class="row" style="margin-top: 4%; margin-left: 6%; margin-right: 60%">
	<h1 class="titulo"> Info PooL </h1>	
	
    <form role="form" action="indexViajero.jsp" method="post">        
	        <div class="form-group">
	          
	           <strong><label for="nombre">Nombre</label></strong>
	            <input class="form-control" type="text" name="nombre" >
	            <p class="help-block">Inserte aqu&iacute; su nombre.</p>
	        </div>
	         <div class="form-group">
	          
	           <strong><label for="apellido">Apellido</label></strong>
	            <input class="form-control" type="text" name="apellido" >
	            <p class="help-block">Inserte aqu&iacute; su apellido.</p>
	        </div>
	         <div class="form-group">
	          
	           <strong><label for="tel">Telefono</label></strong>
	            <input class="form-control" type="number" name="tel" >
	            <p class="help-block">Inserte aqu&iacute; su telefono.</p>
	        </div>
	         <div class="form-group">
	          
	           <strong><label for="mail">e-mail</label></strong>
	            <input class="form-control" type="email" name="email" >
	            <p class="help-block">Inserte aqu&iacute; su nombre.</p>
	        </div>

	        <div class="form-group">
	            <strong><label for="pass">Pasword</label></strong>
	            <input class="form-control" type="text" name="pass">
	            <p class="help-block">Inserte aqu&iacute; su contrase&ntilde;a.</p>
	        </div>
	          <div class="form-group">
	            <strong><label for="pass">Repetir Pasword</label></strong>
	            <input class="form-control" type="text" name="pass">
	            <p class="help-block">Inserte aqu&iacute; su contrase&ntilde;a.</p>
	        </div>
			<div class="form-group">
				<label>Foto Personal</label><input id="file-3" type="file" multiple=true>
			</div>
	     
			<br></br>

		 <div class="col-sm-6">
	     	     	
	     </div>
	      <div class="col-sm-6">
	     	<a href="indexViajero.jsp"><button type="button" class="btn btn-default">Enviar</button>	   </a>  	
	     </div>
	      <div class="col-sm-6">

	     </div>

	     
        
    </form>
</div>
</body>
</html>