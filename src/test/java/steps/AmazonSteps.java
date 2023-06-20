package steps;

import io.cucumber.java.en.*;

public class AmazonSteps {
	@Given("el usuario navega en www.amazon.com")
	public void el_usuario_navega_en_www_amazon_com() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("busca el articulo {string}")
	public void busca_el_articulo(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("navega a la pagina {int} de los resultados de busqueda obtenidos")
	public void navega_a_la_pagina_de_los_resultados_de_busqueda_obtenidos(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("selecciona el tercer item de los resultados")
	public void selecciona_el_tercer_item_de_los_resultados() {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Then("agrega al carrito mas de dos unidades del tercer item si esta disponible para compra")
	public void agrega_al_carrito_mas_de_dos_unidades_del_tercer_item_si_esta_disponible_para_compra() {
	    // Write code here that turns the phrase above into concrete actions
	}
}
