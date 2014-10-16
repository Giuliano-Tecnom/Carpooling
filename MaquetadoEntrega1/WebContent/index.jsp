<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="heder.jsp"></jsp:include>
	
	<div class="row" style="margin-top: 4%; margin-left: 6%; margin-right: 60%">
	<h1 class="titulo"> Info PooL </h1>	
	
    <form role="form" action="#" method="post">        
	        <div class="form-group">
	          
	           <strong><label for="usario">Username</label></strong>
	            <input class="form-control" type="text" name="usuario" >
	            <p class="help-block">Inserte aqu&iacute; su nombre de usuario.</p>
	        </div>
	        <div class="form-group">
	            <strong><label for="pass">Pasword</label></strong>
	            <input class="form-control" type="text" name="pass">
	            <p class="help-block">Inserte aqu&iacute; su contrase&ntilde;a.</p>
	        </div>
	     
	     <div class="col-sm-6">
	     	<button type="submit" class="btn btn-primary" disabled="disabled">Ingresar</button>	     	
	     </div>
	      <div class="col-sm-6">
	     	<button type="submit" class="btn btn-default" disabled="disabled">Registrarse</button>	     	
	     </div>
	      <div class="col-sm-6">
	     	    <a href="indexAdmin.jsp">ingresar como admin</a>	
	     </div>
	      <div class="col-sm-6">
	     	<a href="indexCliente.jsp">ingresar como cliente</a>	     	
	     </div>	  
	     
	     
        
    </form>
</div>
</body>
</html>