var eventSource = new EventSource("/getEmitter");

eventSource.addEventListener("lll0s2u5-incidencias", function(event) {

	var incidencia_json = JSON.parse(event.data);

	var tabla = document.getElementById("tablaDeIncidencias");
	var tam_tabla = tabla.rows.length;
	
	var row = tabla.insertRow( tam_tabla );	
	var name = row.insertCell(0);
	var state = row.insertCell(1);
	var enlace_gestion = row.insertCell(2);
	var enlace_detalles = row.insertCell(3);
	
	name.innerHTML = '<td>' + incidencia_json.nombre_incidencia + '</td>';
	state.innerHTML = '<td>' + incidencia_json.estado + '</td>';
	enlace_gestion.innerHTML = '<td><a href = "/incidencias/edit/'+ incidencia_json.id +'">Gestionar</a></td>';
	enlace_detalles.innerHTML = '<td><a href = "/incidencias/details/'+ incidencia_json.id +'">Detalles</a></td>';

});