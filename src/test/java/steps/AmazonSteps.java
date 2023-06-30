package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.AmazonPage;

//Esta clase modela los steps del archivo Amazon.feature
public class AmazonSteps {
	private WebDriver driver;
	private AmazonPage amazonPage;
	
	
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

	@When("busca el articulo {string}") //
	public void busca_el_articulo(String producto) {
		amazonPage.buscarElArticuloAlexa();
	}

	@And("navega a la pagina {int} de los resultados de busqueda obtenidos")
	public void navega_a_la_pagina_de_los_resultados_de_busqueda_obtenidos(Integer numeroPagina) {
	    amazonPage.irHaciaSegundaPaginaResultados(numeroPagina);
	   
	}

	@And("selecciona el tercer item de los resultados")
	public void selecciona_el_tercer_item_de_los_resultados() {
	   amazonPage.seleccionarTercerProducto();
	   
	}
	
	@Then("agrega al carrito mas de dos unidades del tercer item si esta disponible para compra")
	public void agrega_al_carrito_mas_de_dos_unidades_del_tercer_item_si_esta_disponible_para_compra() {
		amazonPage.agregarAlCarritoDeCompras();
		Assert.assertTrue("El prducto buscado no se encuentra disponible para "
				+ "comprar o la cantidad escogida no esta disponible"
				,amazonPage.mensajeSubtotalProductos.contains(amazonPage.getCantidadProductos()+" productos"));
		
	}

	
/*En esta ultima instruccion, se crea una etiqueta After de cucumber para cerrar el navegador despues de cada
prueba ejecutada	
*/
	
@After
public void finalizarVentanaAutomatizacion() {
amazonPage.esperaImplicita(15);
amazonPage.cerrarNavegador();	
}}
