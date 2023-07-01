Manejador de dependencias: maven
versión maven: 3.8.6
Versión JDK: 19
Sistema operativo: Windows 11

IDE: Eclipse IDE for Java Developers - 2023-06

Dependencias con sus versiones:
Selenium 3.141.59
Cucumber 7.12.0
Cucumber-junit 7.12.0
junit-jupiter 5.9.3
cucumber-reporting 5.7.6

Nota: se usa la herramienta de "Eclipse MarketPlace" ubicada en la opción help de la bara de herramientas de eclipse
para instalar el pluggin de Cucumber.


Para visualizar el reporte de cucumber que se genera despues de toda la ejecución de los tests, hay que dirigirse 
a la siguiente ruta del proyecto: src/test/reporte y se encuentra un archivo .html


Comando para correr el proyecto:
Se abre una terminal de cmd en windows sobre la carpeta del proyecto y se corren los siguientes comandos
 mvn install
mvn clean
mvn test


Para tener en cuenta: El framework está configurado para cerrar la ventana del navegador unos segundos despues 
de que cada test cada que se termina.