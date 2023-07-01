package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/*esta clase solo se crea pero no se implementa nada dentro de ella. Se usan solo unas etiquetas que
sirven para ejecutar las pruebas de los steps.*/ 



/*
  la etiqueta CucumberOptions recibe una serie de parametros. 
  
Features: toma el valor de la ruta del proyecto donde estan todos los archivos .feature
   
Steps: toma como valor el nombre de la carpeta o paquete donde estan los steps de cada archivo .feature	
 
 */



@RunWith(Cucumber.class) //esta etiqueta indica que se correrá un test de tipo cucumber
@CucumberOptions(
features = "src/test/features/Amazon.feature",
glue = {"steps"},
tags = "@prueba",
plugin = { "pretty", "html:src/test/reporte/escenario-busqueda-amazon,reporte.html"}, //
monochrome = true

		)


public class TestRunner {
	
}
