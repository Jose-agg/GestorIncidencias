# Loader_e2a #

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/512e4b265b9e46a5b0f47bb4ace9f262)](https://www.codacy.com/app/jelabra/Loader_e2a?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Arquisoft/Loader_e2a&amp;utm_campaign=Badge_Grade)
[![Build Status](https://travis-ci.org/Arquisoft/Loader_e2a.svg?branch=master)](https://travis-ci.org/Arquisoft/Loader_e2a)
[![codecov](https://codecov.io/gh/Arquisoft/Loader_e2a/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/Loader_e2a)

Este repositorio contiene el código de uno de los submódulos del proyecto: Gestión de Incidencias de la asignatura Arquitectura del Software del grado Ingeniería Informática del Software. Para ver más información visite el [repositorio principal](https://github.com/MrKarrter/GestorIncidencias).

## AUTORES 2017-2018 ##

La versión que contiene este repositorio fue ampliada por los siguientes usuarios:

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

## AUTORES 2016-2017 ##

La versión inicial del proyecto corre a cargo de los siguientes usuarios:

* Herminio García González (@herminiogg)
* Jose Emilio Labra Gayo (@labra)
* Daniel Bermejo Blanco (@UO204115)
* Pedro Fernández Álvarez (@UO244928)
* Darío Alonso Díaz (@UO237089)
* Jonathan Vallés Robla (@UO231850)

- - - -

## Introducción al repositorio ##

Este repositorio pertenece a la parte *Loader* del grupo de trabajo **E2A**, encargada de cargar agentes (personas, sensores, entidades, etc.) que envían incidencias al sistema. La carga se lleva a cabo desde un fichero Excel, y se almacenan los datos en una base de datos para, posteriormente, ser procesada por otros módulos.

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
![descargar_zip](https://github.com/MrKarrter/GestorIncidencias/blob/master/readme_imagenes/Descarga_Loader.png)

Descomprimimos el archivo, lo que nos creará una carpeta con el mismo nombre. 
![zip](https://github.com/MrKarrter/GestorIncidencias/blob/master/readme_imagenes/Zip_Loader.png)

Una vez dentro hacemos clic en el explorador de archivos y escribimos *cmd* lo que nos abrirá un terminal del sistema en la ruta actual.
Para asegurarnos de que se están creado bien las dependencias del proyecto, vamos a comprobar previamente el correcto funcionamiento de las pruebas con la orden:
```bash
mvn test
```
Este proceso tardará alrededor de 1 minuto en completarse y, si todo ha ido bien, debería aparecer algo similar a la siguiente imagen:
![test](https://github.com/MrKarrter/GestorIncidencias/blob/master/readme_imagenes/Test_Loader.png)

Ahora vamos a ejecutar la aplicación. El formato del comando a escribir seria el siguiente:
```bash
mvn exec:java -Dexec.mainClass="es.uniovi.asw.Application" -Dexec.args="excel ruta_fichero_excel ruta_fichero_csv"
```
Donde *ruta_fichero_excel* seria un fichero de extensión .xlsx con la lista de agentes y *ruta_fichero_csv* un fichero de extensión .csv con la lista de tipos de agentes que puede haber. Para este ejemplo usaremos los archivos que se adjuntan al repositorio, por lo que la orden seria.
```bash
mvn exec:java -Dexec.mainClass="es.uniovi.asw.Application" -Dexec.args="excel src\test\resources\test1.xlsx src\test\resources\TiposAgentes.csv"
```
Tras unos 30 segundos, veremos la lista de tipos de agentes que se han leído del .csv y la lista de  agentes que se han añadido a la base de datos (en el archivo que viene con el repositorio ya habían sido añadidos todos los usuario).
![ejecucion](https://github.com/MrKarrter/GestorIncidencias/blob/master/readme_imagenes/Ejecucion_Loader.png)

