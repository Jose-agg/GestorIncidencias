# language: es
Característica: Ver formulario en la aplicacion
	Como Agente del tipo Persona
	Quiero iniciar sesion en la aplicacion
	Para ver la pantalla de bienvenida
Escenario: Pantalla principal de la aplicacion
	Dado un Agente "Juan"
	Y contraseña "1234"
	Y tipo "Person"
	Cuando rellene el formulario de inicio de sesion y haga click en el boton "Enviar"
	Entonces se aceptará al agente y se mostrará la pantalla de bienvenida