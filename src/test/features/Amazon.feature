#Autor: sebastian cordoba
#Date: 29/06/2023
#Descripcion: archivo feature para crear los steps de aniadir el producto al carrito de compras.


@prueba
Feature: Como usuario de Amazon.com cuando busco por el articulo Alexa deseo revisar si la tercera opcion de
  la segunda pagina de resultados esta disponible para compra y puede ser aniadida al carro de compras.

  Scenario Outline: Cargar al carrito de compra un producto encontrado a traves de busqueda con nombre del articulo

    Given el usuario navega en www.amazon.com

    When busca el articulo <producto>

    And navega a la pagina 2 de los resultados de busqueda obtenidos

    And selecciona el tercer item de los resultados

    Then agrega al carrito mas de dos unidades del tercer item si esta disponible para compra
    
 Examples:   
  |producto	|  
  |Alexa		|
  |Iphone		|
  |Portatil	|

    
    