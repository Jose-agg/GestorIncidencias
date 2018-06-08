# InciManager_e2a #

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/7f82a6aac6f3414f82dfc247aa78d98e)](https://www.codacy.com/app/JesusGarciaMinas/InciManager_e2a?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Arquisoft/InciManager_e2a&amp;utm_campaign=Badge_Grade)
[![Build Status](https://travis-ci.org/Arquisoft/Agents_e2a.svg?branch=master)](https://travis-ci.org/Arquisoft/InciManager_e2a)
[![codecov](https://codecov.io/gh/Arquisoft/InciManager_e2a/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/InciManager_e2a)

Este repositorio contiene el código de uno de los submódulos del proyecto: Gestión de Incidencias de la asignatura Arquitectura del Software del grado Ingeniería Informática del Software. Para ver más información visite el [repositorio principal](https://github.com/MrKarrter/GestorIncidencias).

## AUTORES 2017-2018 ##

La versión que contiene este repositorio fue desarrollada en su totalidad por los siguientes usuarios:
+ Jesús García Minas.
> [@JesusGarciaMinas](https://github.com/JesusGarciaMinas)

> UO250999

+ Pelayo García Torre.
> [@Pelayo-Torre](https://github.com/Pelayo-Torre)

> UO251143

+ José Antonio García García.
> [@MrKarrter](https://github.com/MrKarrter)

> UO251317

- - - -

## Introducción al repositorio ##

Este repositorio pertenece a la parte *InciManager* del grupo de trabajo **E2A**, encargada de gestionar un servicio web que ofrezca a los agentes la posibilidad de crear incidencias y enviarlas al sistema de gestión para que sean tratadas. Además, cuenta con un sistema de historial para ver la lista de incidencias que han sido creadas.

## Como probar el proyecto ##
Los pasos a seguir en esta guía están preparados para ser ejecutados en una maquina con un sistema operativo Windows. En el caso de querer probarlo en una maquina Linux, compruebe el repositorio [inicial](https://github.com/MrKarrter/GestorIncidencias).

Lo primero es comprobar que tenemos una versión de Java y Maven funcionando en el sistema. Para ello vamos a abrir un terminal del sistema:
1.	Presionamos en las teclas Windows + R.
2.	En la ventana que se abre escribimos: *cmd* y damos a la tecla Intro.
3.	Una vez abierto el terminal escribimos esta orden y nos debería mostrar algo similar a la imagen de la izquierda.
```bash
java -version
```
4.	Despues escribimos esta otra orden y nos debería mostrar algo similar a la imagen de la derecha.
```bash
mvn -version
```
![versiones](https://github.com/MrKarrter/GestorIncidencias/blob/master/readme_imagenes/Version_Java_Maven.png)
En el caso de que esto no funcione, vuelva a instalar Java o Maven y pruebe de nuevo.

Ahora nos descargaremos la versión zip del repositorio:
![descargar_zip](https://github.com/MrKarrter/GestorIncidencias/blob/master/readme_imagenes/Descarga_Manager.png)

Descomprimimos el archivo, lo que nos creará una carpeta con el mismo nombre. 
![zip](https://github.com/MrKarrter/GestorIncidencias/blob/master/readme_imagenes/Zip_Manager.png)

Una vez dentro hacemos clic en el explorador de archivos y escribimos *cmd* lo que nos abrirá un terminal del sistema en la ruta actual.
Para asegurarnos de que se están creado bien las dependencias del proyecto, vamos a comprobar previamente el correcto funcionamiento de las pruebas con la orden:
```bash
mvn test
```
Este proceso tardará alrededor de 1 minuto en completarse y, si todo ha ido bien, debería aparecer algo similar a la siguiente imagen:
![test](https://github.com/MrKarrter/GestorIncidencias/blob/master/readme_imagenes/Test_Manager.png)

Ahora vamos a ejecutar la aplicación. Para ello vamos a ejecutar el comando:
```bash
mvn spring-boot:run
```
Tras unos 10 segundos, veremos una imagen similar a la siguiente que nos indicará que la aplicación esta lanzada.
![ejecucion](https://github.com/MrKarrter/GestorIncidencias/blob/master/readme_imagenes/Ejecucion_Manager.png)

<a name="DatosEntrada"></a>
### Servicio Web ###
Para comprobar su correcto funcionamiento abriremos un navegador web y visitaremos la siguiente url:

[http://localhost:8085](http://localhost:8085)

Lo que nos debería llevar a una pagina web con el siguiente aspecto.
![funcionamiento](https://github.com/MrKarrter/GestorIncidencias/blob/master/readme_imagenes/Funcionamiento_Manager.png)
Para probar como se ve por dentro, rellenaremos los campos de la siguiente forma:
- Usuario: Pepe
- Contraseña: 123456
- Tipo de Usuario: Entity

Una vez dentro ya podremos consultar las incidencias creadas previamente por el usuario *Pepe* o crear una nueva. 

En el caso de querer crear una nueva incidencia hay que seguir una serie de reglas:
* No se pueden introducir campos con los símbolos “@” ni “$” ya que son utilizados por la aplicación.
* El título y la descripción tienen un minimo y un máximo:
    * Título: mínimo de 5 caracteres y máximo de 24.
    * Descripcion: mínimo de 5 caracteres y máximo de 200.
* Las etiquetas se separarán por comas sin dejar espacios.
* Los campos se separarán por comas sin dejar espacios y cada campo seguirá el formato:
```
Clave:Valor
```
* La localización se registrará automáticamente, sin embargo, será posible cambiarla a mano siempre y cuando siga siendo un número decimal.

Este seria un ejemplo de una incidencia valida.
![funcionamiento](https://github.com/MrKarrter/GestorIncidencias/blob/master/readme_imagenes/Funcionamiento_Manager_2.png)


Una vez rellenados todos los campos y enviada la incidencia se mostrará un mensaje como este.
![funcionamiento](https://github.com/MrKarrter/GestorIncidencias/blob/master/readme_imagenes/Funcionamiento_Manager_3.png)


## Gatling ##

Hemos usado Gatling para las pruebas de carga de la aplicación. Para ver los resultados descargue la carpeta que aparece en [este directorio](https://unioviedo-my.sharepoint.com/:f:/g/personal/uo251017_uniovi_es/EgJm0oEGSz1Oiso5Zf-Deb0BGOpMnNJaqJUY8f2n91A6Mw?e=K8ETc2) y abra el fichero index.html
