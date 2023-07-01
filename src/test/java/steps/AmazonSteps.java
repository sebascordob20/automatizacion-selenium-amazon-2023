package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.AmazonPage;

//Esta clase modela e implementa los steps del archivo Amazon.feature
public class AmazonSteps {
	private WebDriver driver;
	private AmazonPage amazonPage;
	private int pantallazoContador = 1;
	
	
	/*Esta etiqueta @Before de cucumber sirve para ejecutar una instrucción antes de cada paso,
	  en este caso, se crea la pagina de amazon y se crea una nueva instancia del driver la cual usará
	  la página de amazon*/
	
	@Before
	public void inicializar() {
		amazonPage = new AmazonPage(driver);
		driver = amazonPage.crearConexionDriver();
		amazonPage.maximizarNavegador();
	}
	
	@Given("el usuario navega en www.amazon.com")
	public void el_usuario_navega_en_www_amazon_com() {
		amazonPage.navegarHaciaAmazon();
	}

	/*aqui en el siguiente step usa un signo ^ y un &. Entre estos 2 va el valores se escribe
	 el contenido del step correspondiente en el archivo .feature. Y la expresion regular (.*) 
	 indica que se recibe un parametro de tipo String en este caso, que se va a pasar 
	 por medio de una data table de cucumber.*/
	
	@When("^busca el articulo (.*)$") //{string}
	public void busca_el_articulo(String producto) {
		amazonPage.buscarElArticulo(producto);
	}

	
	
	@And("navega a la pagina {int} de los resultados de busqueda obtenidos")
	public void navega_a_la_pagina_de_los_resultados_de_busqueda_obtenidos(Integer numeroPagina) {
	    amazonPage.irHaciaSegundaPaginaResultados(numeroPagina);
	   
	}

	@And("selecciona el tercer item de los resultados")
	public void selecciona_el_tercer_item_de_los_resultados() {
	   amazonPage.seleccionarTercerProducto();
	   
	}
	
	/*En este ultimo step se incluye la asersion con junit donde se valida que la cantidad de producto
	  escogida fue agregada correctamente al carrito de compras*/
	
	@Then("agrega al carrito mas de dos unidades del tercer item si esta disponible para compra")
	public void agrega_al_carrito_mas_de_dos_unidades_del_tercer_item_si_esta_disponible_para_compra() {
		amazonPage.agregarAlCarritoDeCompras();
		Assert.assertTrue("El prducto buscado no se encuentra disponible para "
				+ "comprar o la cantidad escogida no esta disponible"
				,amazonPage.mensajeSubtotalProductos.contains(amazonPage.getCantidadProductos()+" productos"));
		
	}

	

//En esta anotacion afterStep se crea un pantallazo por cada step.
	
@AfterStep
public void tomarPantallazoStepsEscenario(Scenario scenario) {
    // Tomar la captura de pantalla 
    byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

    // Adjuntar la captura de pantalla al reporte de Cucumber
    scenario.attach(screenshot, "image/png", "Pantallazo "+pantallazoContador);
    pantallazoContador++;
}



/*En esta ultima instruccion, se crea una etiqueta After de cucumber para cerrar el navegador despues de cada
prueba ejecutada	
*/
	
@After
public void finalizarVentanaAutomatizacion() {
amazonPage.esperaImplicita(7);
amazonPage.cerrarNavegador();	
}



}
