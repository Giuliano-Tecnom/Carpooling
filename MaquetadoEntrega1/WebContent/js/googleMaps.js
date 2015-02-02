var autocompleted = null;
var autocompletedRecorridoInicio = null;
var autocompletedRecorridoFin = null;
var places = null;
var geocoder = null;
//Para usar las funciones de google maps:
//1) Incluyo el archivo googleMaps.js en el archivo donde lo voy a utilizar
//2) Creo un elemento input en el archivo con id 'dir'y le pongo onblur="eligioDireccion()". Esta funcion obtiene el objeto googleMaps
//3) si quiero que al elegir una dirección me arme el mapa, creo un elemento div con id=map_canvas y style=width:100%;heigth:500px

function construirMapa(lat,long){
	console.log(lat + " - "+long)
	
	var mapOptions = {
	  center: new google.maps.LatLng(lat,long),
	  disableDefaultUI: true,
	  draggable: false,
	  keyboardShortcuts: false,
	  zoom: 16,
	  minZoom:16,
	  maxZoom:16,
	  mapTypeId: google.maps.MapTypeId.ROADMAP
	};
	
	var map = new google.maps.Map(document.getElementById("map_canvas"),mapOptions);
	$("#mapa").show();

};


function eligioDireccion(){
	var input = document.getElementById("dir");
	setTimeout(function() { 
		places = autocompleted.getPlace();
		if(!places == false){
			construirMapa(places.geometry.location.k,places.geometry.location.D);
		}else{
			alert("Inserte una direcci&oacute;n valida");
		};			
	}, 1000);
};

function initialize() {
		var defaultBounds = new google.maps.LatLngBounds(new google.maps.LatLng(-35, -58),new google.maps.LatLng(-34, -57));
		var input = document.getElementById("dir");
		var inputRecorridoInicio = document.getElementById("direccionInicio");
		var inputRecorridoFin = document.getElementById("direccionFin");
		
		var options = {
		  bounds: defaultBounds,
		  types: ['address']
		};
		
		if(input != null){
			$("#mapa").hide();
			autocompleted = new google.maps.places.Autocomplete(input, options);
			if(document.getElementById("dir").value != ""){
				geocoder = new google.maps.Geocoder();
				geocoder.geocode(
						{'address': document.getElementById("dir").value}, 
						function(result){ 
							construirMapa(result[0].geometry.location.k,result[0].geometry.location.D);
						},
						function(error){
							
						});
			};		
		}else{
			autocompletedRecorridoInicio = new google.maps.places.Autocomplete(inputRecorridoInicio, options);
			autocompletedRecorridoFin = new google.maps.places.Autocomplete(inputRecorridoFin, options);
		};	
};

	
window.onload = initialize;	