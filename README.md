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
a la siguiente ruta del proyecto: src/test/reporte y se encuentra un archivo .html. Dentro del reporte despues del ultimo step de cada prueba ejecutada
aparece la opción para ver los pantallazos generados por step del caso de prueba.


Comando para correr el proyecto:
Se abre una terminal de cmd en windows sobre la carpeta raiz del proyecto y se corren las siguientes opciones de comandos:
 1. mvn install (probablemente despues de instalar las dependencias ejecutará la clase Runner del proyecto y se correran los tests).

2. mvn clean y luego mvn pacakge.

3. mvn test (Funcionará siempre y cuando el proyecto ya tenga las respectivas versiones de java y maven. También si tiene las dependencias 
del archivo pom.xml instaladas).



Para tener en cuenta: El framework está configurado para cerrar la ventana del navegador unos segundos despues 
de que cada test se termina.
