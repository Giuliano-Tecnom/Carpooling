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
	
    <form role="form" action="registrarViajero" method="post">        
	        <div class="form-group">
	          
	           <strong><label for="nombre">Nombre</label></strong>
	            <input class="form-control" type="text" name="nombre" id="nombre" required>
	            <p class="help-block">Inserte aqu&iacute; su nombre.</p>
	        </div>
	         <div class="form-group">
	          
	           <strong><label for="apellido">Apellido</label></strong>
	            <input class="form-control" type="text" name="apellido" id="apellido" required>
	            <p class="help-block">Inserte aqu&iacute; su apellido.</p>
	        </div>
	         <div class="form-group">
	          
	           <strong><label for="tel">Telefono</label></strong>
	            <input class="form-control" type="tel" name="telefono" id="tel" required>
	            <p class="help-block">Inserte aqu&iacute; su telefono.</p>
	        </div>
	        <div class="form-group">
	          
	           <strong><label for="dir">Direcci&oacute;n</label></strong>
	            <input class="form-control" type="text" name="direccion" id="dir" required>
	            <p class="help-block">Inserte aqu&iacute; su direcci&oacute;n.</p>
	        </div>
	        
	        <div class="form-group">
	          
	           <strong><label for="doc">N&uacute;mero de documento</label></strong>
	            <input class="form-control" type="text" name="dni" id="doc" required>
	            <p class="help-block">Inserte aqu&iacute; su n&uacute;mero de documento.</p>
	        </div>
	        
	         <div class="form-group">
	          
	           <strong><label for="mail">e-mail</label></strong>
	            <input class="form-control" type="email" name="email" id="mail" required>
	            <p class="help-block">Inserte aqu&iacute; su email.</p>
	        </div>
	        
	         <div class="form-group">
	          
	           <strong><label for="user">Usuario</label></strong>
	            <input class="form-control" type="text" name="usuario" id="user" required>
	            <p class="help-block">Inserte aqu&iacute; el usuario con el que va a acceder al sistema.</p>
	        </div>

	        <div class="form-group">
	            <strong><label for="pass">Pasword</label></strong>
	            <input class="form-control" type="password" name="pass" id="pass" required>
	            <p class="help-block">Inserte aqu&iacute; su contrase&ntilde;a de usuario.</p>
	        </div>	          
			<div class="form-group">
				<label for="foto">Foto Personal</label>
				<input id="foto" type="file" name="foto" multiple=true>
			</div>
	     
			<br></br>
		
		 <div class="form-group">
			 <div class="col-sm-6">
		     	<a class="btn btn-default pull-left btn-block" href="index.jsp" style="margin-bottom: 40px;">Atras</a>
		     	    	 	
		     </div>
		      <div class="col-sm-6">
				<button type="submit" class="btn btn-success pull-right btn-block" style="margin-bottom: 40px;margin-right: -14px;">Enviar</button>	 
		     </div>
		</div>
	     
        
    </form>
</div>
</body>
</html>