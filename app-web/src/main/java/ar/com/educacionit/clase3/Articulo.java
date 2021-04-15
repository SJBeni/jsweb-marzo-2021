package ar.com.educacionit.clase3;

import java.util.Arrays;

public class Articulo implements Comparable<Articulo>{
	
	public final String nombre = "ARTICULO";
	
	//atributo de instancia --> le corresponde a cada objeto que se instancie
	private String titulo;
	private String autor;
	private Float precio;
	private String imagenPpal;
	private String[] imagenesExtras;
	
	
	//atributo de clase
	static String tipo = "ARTICULO";
	public static Integer cantidadInstancias = 0;	//inicia en 0
	
	
	//constructores //alt+shift+s para desplegar asistente
	
	public Articulo(String titulo, String autor, Float precio) {
		inicializar(titulo, precio);
		this.autor = autor;
	}

	public Articulo(String titulo, Float precio) {
		inicializar(titulo, precio);
	}
	
	private void inicializar(String titulo, Float precio) {
		this.titulo = titulo;
		this.precio = precio;
		this.imagenPpal = "";
		this.imagenesExtras = new String[] {};	//inicializamos el vector de imagenes como vacio
		//aumento en 1 la cantidadInstancias
		Articulo.cantidadInstancias++;
	}

	public boolean tieneAutor() {
		return this.autor != null;
	}
	
	//metodos get y set
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public final void display() {
		System.out.println("Titulo: " + this.getTitulo());
		if(this.tieneAutor()) {
			System.out.println("Autor: " + this.getAutor());
		}
		
		System.out.println("Precio: " + this.getPrecio());
		
		//agregamos los dos atributos: imagenPpal e imagenesExtras
		System.out.println("Imagen Principal: ");
		if(this.tieneImagen()) {
			System.out.println(this.imagenPpal);
		}
		
		System.out.println("Imagenes Extras: ");
		if(this.tieneImagenesExtras()) {
			System.out.println(Arrays.toString(this.imagenesExtras));
		}
		//desde el padre, llamo a un metodo del hijo
		this.displayHijo();
		
	}
	
	//por defecto este metodo no tiene logica, esta definida en las clases hijos
	public void displayHijo() {
		
	}

	public String getImagenPpal() {
		return imagenPpal;
	}

	public void setImagenPpal(String imagenPpal) {
		this.imagenPpal = imagenPpal;
	}

	public String[] getImagenesExtras() {
		return imagenesExtras;
	}

	public void setImagenesExtras(String[] imagenesExtras) {
		this.imagenesExtras = imagenesExtras;
	}
	
	public boolean tieneImagen() {
		return !this.imagenPpal.equals("");
	}
	
	public boolean tieneImagenesExtras() {
		return this.imagenesExtras.length > 0;
	}

	@Override
	//este metodo retorna 0, <0 , >0
	//retorna >0 --->implica que esteArticulo es mayor que otroArticulo
	//retorna = 0 --->implica que esteArticulo es igual a otroArticulo
	//retorna <0 ---> implica que esteArticulo es menor a otroArticulo
	public int compareTo(Articulo otroArticulo) {
		//comparacion que me va a dar el orden en la coleccion
		
		Articulo esteArticulo = this;
		return esteArticulo.getPrecio().compareTo(otroArticulo.getPrecio());
	}

	@Override
	public String toString() {
		return "Articulo [titulo=" + titulo + ", autor=" + autor + ", precio=" + precio + "]";
	}
	
	
	
	
}
