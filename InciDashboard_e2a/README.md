# InciDashboard_e2a #

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/5a963e9cc71c4f0c951250172abd6d15)](https://www.codacy.com/app/PablooD9/InciDashboard_e2a?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Arquisoft/InciDashboard_e2a&amp;utm_campaign=Badge_Grade)
[![Build Status](https://travis-ci.org/Arquisoft/InciDashboard_e2a.svg?branch=master)](https://travis-ci.org/Arquisoft/InciDashboard_e2a)
[![codecov](https://codecov.io/gh/Arquisoft/InciDashboard_e2a/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/InciDashboard_e2a)

Este repositorio contiene el código de uno de los submódulos del proyecto: Gestión de Incidencias de la asignatura Arquitectura del Software del grado Ingeniería Informática del Software. Para ver más información visite el [repositorio principal](https://github.com/MrKarrter/GestorIncidencias).

## AUTORES 2017-2018 ##

La versión que contiene este repositorio fue desarrollada en su totalidad por los siguientes usuarios:
+ César Camblor García.
> [@cesarcamblor](https://github.com/cesarcamblor)

> @UO251281

+ Pablo Díaz Rancaño.
> [@PablooD9](https://github.com/PablooD9)

> @UO251017

+ Fernando De la Torre Cueva.
> [@Ferpobe](https://github.com/ferpobe)

> @UO245182

+ Pablo Álvarez Álvarez.
> [@PabloAlvarezUO251561](https://github.com/PabloAlvarezUO251561)

> @UO251561
- - - -

## Introducción al repositorio ##

Este repositorio pertenece a la parte *InciDashboard* del grupo de trabajo **E2A**, encargada de gestionar un panel de control de incidencias desplegado en la web desde el cual se puedan visualizar que incidencias tienen asignadas los diferentes operarios asi como detalles de las mismas.

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
![descargar_zip](https://github.com/MrKarrter/GestorIncidencias/blob/master/readme_imagenes/Descarga_Dashboard.png)

Descomprimimos el archivo, lo que nos creará una carpeta con el mismo nombre. 
![zip](https://github.com/MrKarrter/GestorIncidencias/blob/master/readme_imagenes/Zip_Dashboard.png)

Una vez dentro hacemos clic en el explorador de archivos y escribimos *cmd* lo que nos abrirá un terminal del sistema en la ruta actual.
Para asegurarnos de que se están creado bien las dependencias del proyecto, vamos a comprobar previamente el correcto funcionamiento de las pruebas con la orden:
```bash
mvn test
```
Este proceso tardará alrededor de 2 minutos en completarse y, si todo ha ido bien, debería aparecer algo similar a la siguiente imagen:
![test](https://github.com/MrKarrter/GestorIncidencias/blob/master/readme_imagenes/Test_Dashboard.png)

Ahora vamos a ejecutar la aplicación. Para ello vamos a ejecutar el comando:
```bash
mvn spring-boot:run"
```
Tras unos 15 segundos, veremos una imagen similar a la siguiente que nos indicará que la aplicación esta lanzada.
![ejecucion](https://github.com/MrKarrter/GestorIncidencias/blob/master/readme_imagenes/Ejecucion_Dashboard.png)

<a name="DatosEntrada"></a>
### Servicio Web ###
Para comprobar su correcto funcionamiento abriremos un navegador web y visitaremos la siguiente url:

[http://localhost:8090](http://localhost:8090)

Lo que nos debería llevar a una pagina web con el siguiente aspecto.
![funcionamiento](https://github.com/MrKarrter/GestorIncidencias/blob/master/readme_imagenes/Funcionamiento_Dashboard.png)
Para probar como se ve por dentro tenemos dos opciones: entrar como operario o entrar como administrador. El operario podrá ver las incidencias y el administrador podrá gestionar los campos críticos. Ambos usuarios pueden consultar las estadísticas:
* Operario.
    * Usuario: Juan
    * Contraseña: 123456
* Administrador. 
    * Usuario: Pablo
    * Contraseña: 123456

## Gatling ##
Hemos usado Gatling para las pruebas de carga de la aplicación. Para ver los resultados descargue la carpeta que aparece en [este directorio]( https://unioviedo-my.sharepoint.com/:f:/g/personal/uo251017_uniovi_es/Eq7YPC8qQaREqJ95vVEEEQoBHETV4_TOcZ3cyyUAmlfhkg?e=iVJfff) y abra el fichero index.html
