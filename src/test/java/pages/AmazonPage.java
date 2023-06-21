package pages;

import org.openqa.selenium.WebDriver;

public class AmazonPage extends BasePage {
	private final String urlInicial = "https://www.amazon.com/";

	public AmazonPage(WebDriver driverPage) {
		super(driverPage);
		// TODO Auto-generated constructor stub
	}

	public void navegarHaciaAmazon() {
		navegarHacia(urlInicial);
	}
}
