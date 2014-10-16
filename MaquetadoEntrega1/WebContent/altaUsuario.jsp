<%@include file="/hederAdmin.jsp" %>	 
	 <div class="col-sm-8 panel panel-default">
  				<ol class="breadcrumb">
			        <li>Usuarios</li>
			        <li>Listado</li>
			        <li class="active">Nuevo</li>
			    </ol>
			    <h1 class="page-header">Alta de Usuario
			        <a class="btn btn-info" style="float:right;" href="listadoUsuario.jsp">Volver</a>
			    </h1>
  				<form role="form" style="margin-bottom: 4%">
					  <div class="form-group">
					    <label for="usuario">Usuario</label>
					    <input type="text" class="form-control" id="usuario" placeholder="Nombre de usuario">
					  </div>
					  <div class="form-group">
					    <label for="nombre">Nombre</label>
					    <input type="text" class="form-control" id="nombre" placeholder="Nombre">
					  </div>
					   <div class="form-group">
					    <label for="apellido">Apellido</label>
					    <input type="text" class="form-control" id="apellido" placeholder="Apellido">
					  </div>
					  <div class="form-group">
					    <label for="email">Email</label>
					    <input type="email" class="form-control" id="email" placeholder="Email">
					  </div>
					  <div class="form-group">
					    <label for="domicilio">Domicilio</label>
					    <input type="text" class="form-control" id="domicilio" placeholder="Domicilio">
					  </div>	
					   <div class="form-group">
					    <label for="telefono">Telefono</label>
					    <input type="text" class="form-control" id="telefono" placeholder="Telefono">
					  </div>	  
					  
					  <button type="submit" class="btn btn-success">Guardar</button>
					</form>
		</div>
			
		</div>
    </div>
