<%@include file="/heder.jsp" %>	 
<script type="text/javascript" src="js/googleMaps.js">
</script>
	<div class="col-sm-6">
		<div class="col-sm-2">
		</div>
		<div class="col-sm-10">
			<h1>Registrar Viajero</h1>
		</div>
		<br/>
		<br/>
		<br/>
		<br/>
	    <form class="form-horizontal" action="registrarViajero" method="post">        
	        
	        <div class="form-group">
	        	<label class="col-sm-2" for="nombre">Nombre</label>
	          	<div class="col-sm-10">
	          		<input class="form-control" type="text" name="nombre" id="nombre" required placeholder="Inserte aqu&iacute; su nombre." />
	          	</div>
	        </div>
	        
	        <div class="form-group">
	           <label class="col-sm-2" for="apellido">Apellido</label>
	           <div class="col-sm-10">
	           		<input class="form-control" type="text" name="apellido" id="apellido" required placeholder="Inserte aqu&iacute; su apellido." />
	           </div>
	        </div>
	        <div class="form-group">
	           <label class="col-sm-2" for="tel">Telefono</label>
	           <div class="col-sm-10">
	           		<input class="form-control" type="tel" name="telefono" id="tel" required placeholder="Inserte aqu&iacute; su telefono." />
	           </div>
	        </div>
	        <div class="form-group">
	        	<label class="col-sm-2" for="dir">Direcci&oacute;n</label>
	        	<div class="col-sm-10">
	        		<input class="form-control" type="text" name="direccion" id="dir" required placeholder="Inserte aqu&iacute; su direcci&oacute;n." />
	        	</div>
	        </div>
		        
	        <div class="form-group">
	          	<label class="col-sm-2" for="doc">N&uacute;mero de documento</label>
	          	<div class="col-sm-10">
	          		<input class="form-control" type="text" name="dni" id="doc" required placeholder="Inserte aqu&iacute; su n&uacute;mero de documento." />	
	          	</div>
	        </div>
		        
	        <div class="form-group">
	          	<label class="col-sm-2" for="mail">e-mail</label>
	          	<div class="col-sm-10">
	          		<input class="form-control" type="email" name="email" id="mail" required placeholder="Inserte aqu&iacute; su email." />
	          	</div>
	        </div>
		        
	         <div class="form-group">
	          	<label class="col-sm-2" for="user">Usuario</label>
	            <div class="col-sm-10">
	            	<input class="form-control" type="text" name="usuario" id="user" required placeholder="Inserte aqu&iacute; el usuario con el que va a acceder al sistema." />
	            </div>
	        </div>
	
	        <div class="form-group">
	            <label class="col-sm-2" for="pass">Pasword</label>
	            <div class="col-sm-10">
	            	<input class="form-control" type="password" name="pass" id="pass" required placeholder="Inserte aqu&iacute; su contrase&ntilde;a de usuario." />
	            </div>
	        </div>	          
			<div class="form-group">
				<label class="col-sm-2" for="foto">Foto Personal</label>
				<div class="col-sm-10">
					<input  id="foto" type="file" name="foto" />
				</div>
			</div>
			 <div class="form-group">
				 <div class="col-sm-2"></div>
				 <div class="col-sm-5">
			     	<a class="btn btn-default pull-left btn-block" href="index.jsp" style="margin-bottom: 40px;">Atras</a>
			     	    	 	
			     </div>
			      <div class="col-sm-5">
					<button type="submit" class="btn btn-success pull-right btn-block" style="margin-bottom: 40px;margin-right: -14px;">Enviar</button>	 
			     </div>
			</div>
		     
	        
	    </form>
	</div>

