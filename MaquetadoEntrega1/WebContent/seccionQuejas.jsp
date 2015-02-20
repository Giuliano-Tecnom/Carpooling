<%@taglib uri="/struts-tags" prefix="s"%>
<%@include file="/hederAdmin.jsp" %>	 

<ol class="breadcrumb col-sm-8 ">
        <li class="active">Quejas</li>
    </ol>
	
	<div class="col-sm-8 "> 
	<div class="panel panel-default clearfix">
  		<div class="panel-heading clearfix">   			 
  			<span style="font-size: 24px;">Envio mail de prueba</span>
  		</div>		
		<div class="panel-body"> 	   
  			<form role="form" method="post" action="enviarEmail">
	  			<div class="form-horizontal clearfix">
	  				<div class="form-group clearfix">
	  					<div class="col-sm-3">
	  						<label for="mailOrigen">Mail origen:</label>
	  					</div>
	  					<div class="col-sm-9">
	  						<input type="email" name="from" class="form-control" id="mailOrigen" required/>
	  					</div>
	  				</div>
	  				<div class="form-group clearfix">
	  					<div class="col-sm-3">
	  						<label for="pass">Contraseña:</label>
	  					</div>
	  					<div class="col-sm-9">
	  						<input type="password" name="pass" class="form-control" id="pass" required/>
	  					</div>
	  				</div>
	  				<div class="form-group clearfix">
	  					<div class="col-sm-3">
	  						<label for="mailDestino">Mail destino:</label>
	  					</div>
	  					<div class="col-sm-9">
	  						<input type="email" name="to" class="form-control" id="mailDestino" required/>
	  					</div>
	  				</div>
	  				<div class="form-group clearfix">
	  					<div class="col-sm-3">
	  						<label for="asunto">Asunto:</label>
	  					</div>
	  					<div class="col-sm-9">
	  						<input type="text" name="subject" class="form-control" id="asunto" required/>
	  					</div>
	  				</div>
	  				<div class="form-group clearfix">
	  					<div class="col-sm-3">
	  						<label for="cuerpo">Cuerpo:</label>
	  					</div>
	  					<div class="col-sm-9">
	  						<textarea name="content" class="form-control" id="cuerpo" required></textarea>
	  					</div>
	  				</div>
	  				<div class="form-group clearfix">
	  					<div class=col-sm-12>
	  						<button type="submit" class="btn btn-success btn-block">Enviar</button>
	  					</div>
	  				</div>
	  			</div>
  			</form>
		</div>
	</div>
</div>