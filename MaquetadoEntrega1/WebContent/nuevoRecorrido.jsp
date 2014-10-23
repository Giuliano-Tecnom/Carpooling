
<%@include file="/hederViajero.jsp" %>
<script
src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDY0kkJiTPVd2U7aTOAwhc9ySH6oHxOIYM&sensor=false">
</script>

<script>
function initialize()
{
var mapProp = {
  center:new google.maps.LatLng(51.508742,-0.120850),
  zoom:5,
  mapTypeId:google.maps.MapTypeId.ROADMAP
  };
var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
}

google.maps.event.addDomListener(window, 'load', initialize);
</script>
<div class="col-sm-6 panel panel-default">	
	<div class="row" style="margin-top: 4%; margin-left: 6%; margin-right: 60%">
	<h1 class="titulo"> Info PooL </h1>	
	<form role="form" action="indexViajero.jsp" method="post">        
	        <div class="form-group">
	          
	           <strong><label for="nombre">Registra el viaje :</label></strong>
	           <select class="form-control" >
     			 <option>Conductor</option>
			     <option>Pasajero</option>
			     <option>Ambos</option>
  			   </select>
	        </div>
	         <div class="form-group">
	         	<strong><label for="diario">Diario:</label></strong>
	       		<select multiple class="form-control" >
     			 <option>Lunes</option>
			     <option>Martes</option>
			     <option>Miercoles</option>
			     <option>Jueves</option>
			     <option>Viernes</option>
  			   </select>
	           
	        </div>
	         <div class="form-group">
	         	<strong><label for="periodico">Periodico:</label></strong>
	       		<select multiple class="form-control" >
			     <option>Martes</option>
			     <option>Miercoles</option>
			     <option>Jueves</option>
  			   </select>
	           
	        </div>
	         <div class="form-group">
	        	<strong><label for="periodico">Puntual:</label></strong>
				 <input type="date" name="puntual">
			</div>
			
			<div class="form-group">
	        	<strong><label for="periodico">Es un viaje de ida o de ida/vuelta ?</label></strong><br>
	        	<label for="periodico">Hora de partida:</label>
	        	<input type="time" name="horaPartida">
	        	<label for="periodico">Hora de regreso:</label>
	        	<input type="time" name="horaRegreso">
				 
			</div>
			
			<div class="form-group">
				<label for="periodico">Direccion desde :</label>
	        	<input type="text" name="direDesde"><br>
				<label for="periodico">Direccion hasta :</label>
	        	<input type="text" name="direHasta">
			
			</div>
			<div class="form-group">
				<label for="periodico">Recorrido Google Maps : </label>
				
			</div><iframe src="https://www.google.com/maps/embed?pb=!1m29!1m12!1m3!1d6544.50937677793!2d-57.942819606872106!3d-34.90005751354852!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!4m14!1i0!3e6!4m5!1s0x95a2e6433123af13%3A0x33033750a90032bc!2sCalle+13+41%2C+La+Plata%2C+Buenos+Aires!3m2!1d-34.8973175!2d-57.9426821!4m5!1s0x95a2e66b83557fd1%3A0xb4b8ff92218fc902!2sFacultad+de+Inform%C3%A1tica+-+Universidad+Nacional+de+La+Plata%2C+Calle+50+120%2C+1900+La+Plata%2C+Buenos+Aires!3m2!1d-34.903605!2d-57.937726!5e0!3m2!1ses!2sar!4v1414091829518" width="600" height="450" frameborder="0" style="border:0"></iframe></div>
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