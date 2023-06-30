#Autor: sebastian cordoba
#Date: 29/06/2023
#Descripcion: archivo feature para crear los steps de añadir el producto al carrito de compras.


@prueba
Feature: Como usuario de Amazon.com cuando busco por el artículo Alexa deseo revisar si la tercera opción de
  la segunda página de resultados esta disponible para compra y puede ser añadida al carro de compras.

  Scenario: Cargar al carrito de compra un producto encontrado a través de búsqueda con nombre del artículo

    Given el usuario navega en www.amazon.com

    When busca el articulo "Alexa"

    And navega a la pagina 2 de los resultados de busqueda obtenidos

    And selecciona el tercer item de los resultados

    Then agrega al carrito mas de dos unidades del tercer item si esta disponible para compra
 

    
    