<%@include file="/hederViajero.jsp" %>	 

	 <div class="col-sm-8 panel panel-default">
  				<ol class="breadcrumb">
			        <li>Reccoridos</li>
			        <li class="active">Otros</li>
			    </ol>
			    <h1 class="page-header">Listado de Recorridos Otros
			    
			    </h1>
			<div class="form-group">
	        	<strong><label for="periodico">Filtrar</label></strong>
	      	 <div class="row">
				<div class="col-sm-3">	
				 <input type="date" name="puntual">
				</div>
				<div class="col-sm-3">	
	        	<input type="text" name="direDesde" placeholder="Direccion desde"><br>
	        	</div>
	        	<div class="col-sm-3">	
	        	<input type="text" name="direHasta" placeholder="Direccion hasta">
	        	</div>
	        	<div class="col-sm-3">	
	        	<select class="form-control" >
     			 <option>Conductor</option>
			     <option>Pasajero</option>
			     <option>Ambos</option>
  			   </select>
  			   </div>
  			  	<br>
	        	<div class="col-sm-3">	
	        	<a class="btn btn-default" style="float:right;" href="altaUsuario.jsp">Filtrar</a>
	        	</div>	
	        
	       	</div>
	       </div>
	        	
  				<table class="table table-striped">
 					<thead>
			            <tr>   
			                <th>Viajero</th>   
			                <th>Diario</th>
			                <th>Periodico</th>
			                <th>Puntual</th>
			                <th>Tipo Viaje</th>  
			                <th>Hora Salida</th>
			                <th>Hora Partida</th>          
			                <th>Direccion desde</th> 
			                <th>Direccion hasta</th> 
			                <th style="width:166px;">Acciones</th>			              
			            </tr>
			        </thead>
			        <tbody>
			            <tr>
							<td>Conductor</td>			            
			                <td>-</td>
			                <td>-</td>
			                <td>31/10/2014</td>
			                <td>Ida/Vuelta</td>
			                <td>11:00</td>		
			                <td>14:00</td>		
			                <td>13 y 32 , La Plata</td>	
			                <td>50 y 120, La Plata</td>		                         
			                <td><a href="#" class="btn btn-info">Participar</a><a href="" class="btn btn-danger">Cancelar</a></td>
			                
			
			            </tr>
			        </tbody>    
				</table>
		<br></br>		

		<h1 class="page-header">Viajes a un evento
			    
			    </h1>	    		
				
		<form class="navbar-form navbar-left" role="search">
        	<div class="form-group">
          		<input type="text" class="form-control" placeholder="Viajes a un evento">
        	</div>
        	<button type="submit" class="btn btn-default">Buscar</button>
      </form>
      
      <table class="table table-striped">
 					<thead>
			            <tr>   
			                <th>Viajero</th>  
			                <th>Evento</th> 
			                <th>Puntual</th>
			                <th>Tipo Viaje</th>  
			                <th>Hora Salida</th>
			                <th>Hora Vuelta</th>          
			                <th>Direccion desde</th> 
			                <th>Direccion hasta</th> 
			                <th style="width:166px;">Acciones</th>			              
			            </tr>
			        </thead>
			        <tbody>
			            <tr>
							<td>Conductor</td>	
							<td>CACIC</td>		            

			                <td>31/10/2014</td>
			                <td>Ida/Vuelta</td>
			                <td>11:00</td>		
			                <td>14:00</td>		
			                <td>13 y 32 , La Plata</td>	
			                <td>50 y 120, La Plata</td>		                         
			                <td><a href="#" class="btn btn-info">Participar</a><a href="" class="btn btn-danger">Cancelar</a></td>
			                
			
			            </tr>
			        </tbody>    
				</table>
      
	</div>
</div>