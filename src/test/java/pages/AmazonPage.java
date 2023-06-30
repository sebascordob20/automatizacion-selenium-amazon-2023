package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilidades.Utilidades;

public class AmazonPage extends BasePage { //se hereda de la clase BasePage todos los atributos y métodos

private final String URL_INICIAL = "https://www.amazon.com/";

/*vamos a declarar y a asignar valores a todos los localizadores que seran utiles para encontrar los elementos web
que necesitamos para nuestra automatización
*/

private By campoBusqueda = By.id("twotabsearchtextbox");
private By segundaPaginaLink = By.xpath("//a[text()='2']");
private By tercerResultado = By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[4]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span");
private By disponibleLabel = By.cssSelector("//span[contains(text(),'Cantidad:')]");
//private By dropdonwCantidad = By.cssSelector("span.a-dropdown-label");
private By drodownListCantidad = By.id("quantity");
private By botonAgregarAlCarrito = By.name("submit.add-to-cart");
private By irAlCarrito = By.partialLinkText("Ir al Carri");
private By subtotalProductos = By.xpath("//span[@id='sc-subtotal-label-buybox']");
public static String mensajeSubtotalProductos;
private int cantidadProductos;
	
	public AmazonPage(WebDriver driverPage) {
		super(driverPage);
	}

	public void navegarHaciaAmazon() {
		navegarHacia(URL_INICIAL);
	}
	
	public void buscarElArticuloAlexa() {
		try {
			escribirSobreCampo(campoBusqueda,"Alexa");
		
		
		} catch (Exception e) {
			System.out.print("Hubo un error al tratar de escribir sobre el campo de busqueda");
			esperaImplicita(10); 
			cerrarNavegador();	
		}
		
		
		
	}
	
	public void irHaciaSegundaPaginaResultados(int paginacion) {
		try {
			scrollHaciaElementoWeb(segundaPaginaLink);
			//scrollHaciaUnaPosicion(0,5350);
			 darClic(segundaPaginaLink);
		} catch (Exception e) {
		  e.printStackTrace();
			System.out.print("No fue posible encontrar la segunda pagina");
			esperaImplicita(10);
			cerrarNavegador();
		}
	}
	
	public void seleccionarTercerProducto(){
		try {
			darClic(tercerResultado);
		} catch (Exception e) {
			System.out.println("Hubo un problema y no fue posible localizar el tercer producto de la busqueda Alexa en la segunda página");
		}
	}
	
	public void agregarAlCarritoDeCompras(){
		 cantidadProductos = Utilidades.numeroAleatorioRango(2,30);
		if(estaEnPantalla(drodownListCantidad)){
			seleccionarItemDropDownJavascript(drodownListCantidad,String.valueOf(cantidadProductos));
			darClicJSExecutor(botonAgregarAlCarrito);
			darClicJSExecutor(irAlCarrito);
			mensajeProductosSubtotal();
			
		}else{
		System.out.print("El producto no se encuentra disponible para comprar");
		}
		
	}
	
	public void mensajeProductosSubtotal() {
	mensajeSubtotalProductos = obtenerTextoElemento(subtotalProductos);
	
}
	public int getCantidadProductos() {
	return cantidadProductos;	
	}
	
}
