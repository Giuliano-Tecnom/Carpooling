<%@include file="/heder.jsp" %>	 
<div class="col-sm-6">
	<div class="col-sm-2"></div>
	<div class="col-sm-10">
		<h1 style="cursor: context-menu;"> Info PooL </h1>	
	</div>
	
	
    <form class="form-horizontal" action="login" method="post">        
        <div class="form-group">
	        <label class="col-sm-2" for="usario">Username</label>
	        <div class="col-sm-10">
	        	<input class="form-control" type="text" name="usuario" placeholder="Inserte aqu&iacute; su nombre de usuario." required/>
	        </div>
	    </div>    
        <div class="form-group">
            <label class="col-sm-2" for="pass">Pasword</label>
            <div class="col-sm-10">
            	<input class="form-control" type="password" name="pass" placeholder="Inserte aqu&iacute; su contrase&ntilde;a." required/>
            </div>
        </div>
	    <div class="form-group">
	    	<div class="col-sm-2"></div>
	    	<div class="col-sm-5">
	     		<button type="submit" class="btn btn-primary btn-block" >Ingresar</button>	     	
	     	</div>
	     	<div class="col-sm-5">
	     		<a href="registroViajero.jsp" class="btn btn-default btn-block">Registrarse</a>  	
	     	</div>
	    </div>
    </form>
</div>
