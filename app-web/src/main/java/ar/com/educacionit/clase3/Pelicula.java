package ar.com.educacionit.clase3;

public class Pelicula extends Articulo {
	
	//atributos
	private String productora;
	private String clasificacion;
	
	//constructores
	public Pelicula(String titulo, String autor, Float precio, String productora, String clasificacion) {
		super(titulo, autor, precio);
		inicializar(productora, clasificacion);
	}
	
	public Pelicula(String titulo, Float precio, String productora, String clasificacion) {
		super(titulo, precio);
		inicializar(productora, clasificacion);
	}
	
	private void inicializar(String productora, String clasificacion) {
		this.productora = productora;
		this.clasificacion = clasificacion;
	}

	@Override
	public void displayHijo() {
		System.out.println("PELICULA");
		System.out.println("Productora: " + this.productora);
		System.out.println("Clasificacion: " + this.clasificacion);
	}
	
	//metodos get y set
	public String getProductora() {
		return productora;
	}

	public void setProductora(String productora) {
		this.productora = productora;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	
	
}
