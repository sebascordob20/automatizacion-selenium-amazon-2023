package utilidades;

/*Esta clase se crea para modularizar funcionalidades matematicas para separarlas de la logica
  del webdriver y de la clases pages
o del*/
public class Utilidades {
	 public static int numeroAleatorioRango(int inicio, int fin){    
	       int n = (int) (Math.random() * (fin+ 1- inicio)) +inicio;
	        return n;
	    
	    }
}
