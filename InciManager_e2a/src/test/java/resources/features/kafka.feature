# language: es
Característica: Kafka message
	Como desarrolador
	Quiero enviar una incidencia mediante kafka
	Para que los operarios lo vean
Escenario: Pantalla de formulario rellenada y cursor sobre el boton "Enviar"
	Dado un incendio en el "Parque"
	Cuando el agente "Juan" envia una incidencia de nombre "Fuego en el parque"
	Entonces se enviará dicha incidencia a traves de kafka
	Y los operarios podran tratarla