package ar.com.educacionit.clase3;

public class ContadorDeInstanciasMain {

	public static void main(String[] args) {
		
		System.out.println("Instancias de Articulo: " + Articulo.cantidadInstancias);
		
		//Creamos varios libros
		Libro l = new Libro(null, null, null, null, null);
		System.out.println("Instancias de Articulo: " + Articulo.cantidadInstancias);
		Libro l1 = new Libro(null, null, null, null, null);
		System.out.println("Instancias de Articulo: " + Articulo.cantidadInstancias);
		Libro l2 = new Libro(null, null, null, null, null);
		System.out.println("Instancias de Articulo: " + Articulo.cantidadInstancias);
		Libro l3 = new Libro(null, null, null, null, null);
		System.out.println("Instancias de Articulo: " + Articulo.cantidadInstancias);
		
		
	}

}
