package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
private WebDriver driver;
private WebDriverWait wait;
private final String tipo_driver="webdriver.chrome.driver";
private final String ruta_driver="src/test/driver/chromedriver.exe";



public BasePage(WebDriver driver) {
	this.driver = driver;

}



public WebDriver crearConexionDriver() {
	System.setProperty(tipo_driver, ruta_driver);
	driver = new ChromeDriver();
	wait = new WebDriverWait(driver, 10);
return driver;	
}

public void navegarHacia(String url) {
driver.get(url);
}

public void maximizarNavegador(){
driver.manage().deleteAllCookies();
driver.manage().window().maximize();
}

public WebElement encontrarElemento(By locator){
	return driver.findElement(locator);
	
}

public List<WebElement> encontrarElementos(By locator){
	return driver.findElements(locator);
	
}

public void escribirSobreCampo(By locator, String texto){
 encontrarElemento(locator).sendKeys(texto);
	
}

public void darClic(By locator){
encontrarElemento(locator).click();	
}


public void darDobleClic(By locator) {
Actions actions = new Actions(driver);
actions.doubleClick(encontrarElemento(locator)).perform();
}


public String obtenerTextoElemento(By locator) {
	
return encontrarElemento(locator).getText();	
}

public void cerrarNavegador() {
driver.quit();	
}


public Boolean estaEnPantalla(By locator){
	try {
		return encontrarElemento(locator).isDisplayed();
	} catch (Exception e) {
		return false;
	}
	
}

public void esperar10Segundos(){
	
}




}
