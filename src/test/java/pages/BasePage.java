package pages;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.messages.types.Duration;
import net.bytebuddy.implementation.bytecode.assign.Assigner.EqualTypesOnly;

/*Esta clase es una especie de envoltorio para encapsular las funciones 
 que nos ofrece selenium webdriver.
 */

public class BasePage {
private WebDriver driver;
private WebDriverWait wait;

/*Tanto para la variable tipo_driver y ruta_driver se asignan los valores de una vez en la declaración 
 y se definen de tipo constantes con la palabra final para promover buenas practicas.
*/
private final String tipo_driver="webdriver.chrome.driver";
private final String ruta_driver="src/test/driver/chromedriver.exe";



public BasePage(WebDriver driver) {
	this.driver = driver;

}


/*Este método crea una conexion con el chrome driver e instacia el método wait para ser usado 
implicitamente esperando maximos 10 segundos para encontrar un elemento
*/
public WebDriver crearConexionDriver() { 
	System.setProperty(tipo_driver, ruta_driver);
	driver = new ChromeDriver();
	wait = new WebDriverWait(driver,10); //WebDriverWait(driver, Duration.ofSeconds(10));
return driver;	
}


//este método recibe una ruta para navegar hacia una página
public void navegarHacia(String url) {
driver.get(url);
}

public void maximizarNavegador(){
driver.manage().deleteAllCookies();
driver.manage().window().maximize();
}

public void esperaImplicita(int segundos) {
	
driver.manage().timeouts().implicitlyWait(segundos,TimeUnit.SECONDS);
}

//Este método busca un elemento recibiendo como parametro su respectivo localizador.
public WebElement encontrarElemento(By localizador){
	//En este return, lo que se hace es buscar el elemento e implementar la espera implicita
	return wait.until(ExpectedConditions.visibilityOfElementLocated(localizador));
}


public WebElement elementoClickable(By localizador){
	//En este return, lo que se hace es buscar el elemento e implementar la espera implicita
	return wait.until(ExpectedConditions.elementToBeClickable(localizador));
}
/*Recibe un localizador y devuelve todos los elementos web que contengan dicho localizador
Para ello a nivel de java devolvemos una lista de webElements*/
public List<WebElement> encontrarElementos(By localizador){
	return driver.findElements(localizador);
}

public void escribirSobreCampo(By localizador, String texto){
encontrarElemento(localizador).clear(); //limpiamos el campo de texto encontrado antes de escribir sobre el
encontrarElemento(localizador).sendKeys(texto);
encontrarElemento(localizador).submit();

}


public void darClic(By localizador){
encontrarElemento(localizador).click();	
}


/*Este metodo utiliza la clase JAVAscriptExecutor para ejecutar scripts de javascript.
En este caso buscamos dar clic sobre un elemento con mayor facilidad para evitar posibles exepciones
que arroja el metodo click() de la clase webElement */
public void darClicJSExecutor(By localizador){
	 WebElement elemento_web = driver.findElement(localizador);
		
	 JavascriptExecutor executor = (JavascriptExecutor) driver;
	 executor.executeScript("arguments[0].click();",elemento_web);
	
}

public void darDobleClic(By localizador) {
/*Se crea un objeto de la clase Actions y se le pasa la instancia del driver. Posteriormente se da doble clic 
sobre el elemento*/
Actions actions = new Actions(driver);
actions.doubleClick(encontrarElemento(localizador)).perform();
}


public String obtenerTextoElemento(By localizador) {
	
return encontrarElemento(localizador).getText();	
}


public void cerrarNavegador() {

driver.quit();	
}



/*Valida si un elemento web se encuentra disponible en la pantalla de la ejecución actual de la 
automatizacion
*/
public Boolean estaEnPantalla(By localizador){
	try {
		return encontrarElemento(localizador).isDisplayed();
	} catch (Exception e) {
		return false;
	}
}

/*Cumple la función de scrollear hasta la parte de la pagina actual
donde esta visible un determinado elemento. Para realizar dicha accion, se usa la clase JavascriptExecutor y
se ejecuta el script necesariocon el método executeScript */
public void scrollHaciaElementoWeb(By localizador){
JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
WebElement elementoWeb = driver.findElement(localizador);
jsExecutor.executeScript("arguments[0].scrollIntoView(true);", elementoWeb);
}

/*Cumple la función de hacer un desplazamiento o scroll en una página hasta una coordenada indicada
 */
public void scrollHaciaUnaPosicion(int coordenadaX, int coordenadaY){
	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	jsExecutor.executeScript("window.scroll("+coordenadaX+","+coordenadaY+")");
}


/*Este metodo crea un objeto de tipo select de acuerdo a un parametro localizador y a un valor de la
* lista desplegable que se pasa. El objeto select cumple la funcion de ser un combobox o una lista desplegable en una pagina web*/
public void seleccionarItemCombobox(By localizador, String itemSeleccionado){
Select	combobox = new Select(encontrarElemento(localizador));
combobox.selectByValue(itemSeleccionado);
}

/*Este metodo crea un objeto de tipo select de acuerdo a un parametro localizador y a un index que se pasa
El objeto select cumple la funcion de ser un combobox o una lista desplegable en una pagina web*/
public void seleccionarItemCombobox(By localizador, int indexCombobox){
Select	combobox = new Select(encontrarElemento(localizador));
combobox.selectByIndex(indexCombobox);

}

/*Este metodo utiliza la clase JAVAscriptExecutor para ejecutar scripts de javascript.
En este caso buscamos dar clic sobre un elemento con mayor facilidad para evitar posibles exepciones
que arroja el metodo click() de la clase webElement */
public void seleccionarItemDropDownJavascript(By localizador, String optionValue){
	  WebElement combobox = driver.findElement(localizador);
	
	 JavascriptExecutor executor = (JavascriptExecutor) driver;
	 executor.executeScript("arguments[0].click();",combobox);
      
	String opcion = "//option[@value='" + optionValue + "']";
	darClic(By.xpath(opcion));
	
	
	
}



}
